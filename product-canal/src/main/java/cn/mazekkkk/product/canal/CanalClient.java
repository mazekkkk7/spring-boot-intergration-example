package cn.mazekkkk.product.canal;

import cn.mazekkkk.product.redis.service.IRedisService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;

@Component
public class CanalClient implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private IRedisService iRedisService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Spring 启动执行
     * @param applicationReadyEvent 启动事件
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        this.sync();
        logger.info("==========BinlogStartUpSuccess==========");
    }

    /**
     * MysqlBinlog分析同步方法
     */
    public void sync() {
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(AddressUtils.getHostIp(),
                11111), "example", "canal", "canal");
        int batchSize = 1000;
        try {
            connector.connect();
            connector.subscribe();
            connector.rollback();
            while (true) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    printEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }

    /**
     * 打印记录
     * @param entrys 记录
     */
    private void printEntry( List<Entry> entrys) {
        for (Entry entry : entrys) {
            if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
                continue;
            }
            RowChange rowChage = null;
            String tableName = "";
            try {
                rowChage = RowChange.parseFrom(entry.getStoreValue());
                tableName = entry.getHeader().getTableName();
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }
            EventType eventType = rowChage.getEventType();
            logger.info(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            for (RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == EventType.DELETE) {
                    redisDelete(rowData.getBeforeColumnsList(),tableName);
                } else if (eventType == EventType.INSERT) {
                    redisInsert(rowData.getAfterColumnsList(),tableName);
                } else {
                    logger.info("-------> before");
                    printColumn(rowData.getBeforeColumnsList(),tableName);
                    logger.info("-------> after");
                    redisUpdate(rowData.getAfterColumnsList(),tableName);
                }
            }
        }
    }

    /**
     * 打印列
     * @param columns 列对象
     * @param tableName 表命
     */
    private void printColumn( List<Column> columns,String tableName) {
        for (Column column : columns) {
            logger.info(tableName+column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    /**
     * 同步插入到Redis
     * @param columns 列对象
     * @param tableName 表命
     */
    private void redisInsert( List<Column> columns,String tableName){
        JSONObject json=new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            iRedisService.set(tableName+":"+ columns.get(0).getValue(),json.toJSONString());
        }
    }

    /**
     * 同步更新到Redis
     * @param columns 列对象
     * @param tableName 表命
     */
    private void redisUpdate( List<Column> columns,String tableName){
        JSONObject json=new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            iRedisService.set(tableName+":"+ columns.get(0).getValue(),json.toJSONString());
        }
    }

    /**
     * 同步从Redis删除
     * @param columns 列对象
     * @param tableName 表命
     */
    private void redisDelete( List<Column> columns,String tableName){
        JSONObject json=new JSONObject();
        for (Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            iRedisService.del(tableName+":"+ columns.get(0).getValue());
        }
    }

}