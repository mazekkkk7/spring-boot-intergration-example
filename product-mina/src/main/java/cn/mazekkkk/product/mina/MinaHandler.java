package cn.mazekkkk.product.mina;

import cn.mazekkkk.product.activemq.producer.Producer;
import cn.mazekkkk.product.dao.common.Gametrade;
import cn.mazekkkk.product.redis.service.IRedisService;
import cn.mazekkkk.product.service.GameTradeService;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by maze on 17/2/21.
 */
@Component
public class MinaHandler extends IoHandlerAdapter {

    @Autowired
    private IRedisService iRedisService;
    @Autowired
    private Producer producer;
    @Autowired
    private GameTradeService gameTradeService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        session.close();
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        session.close(true);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("MessageReceived:========="+message);
        logger.info("SessionReceived:========="+session);
        producer.send(message.toString());
        iRedisService.set("text",message.toString());
        Gametrade gametrade = new Gametrade();
        gametrade.setPayamount(1);
        gameTradeService.saveGameTrade(gametrade);
        session.write(message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("MessageSent:========="+message);
        logger.info("SessionSent:========="+session);
        session.write(message);
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }

    public String convertCharSet(String value){
        return String.valueOf(Charset.forName(value));
    }

    public InetSocketAddress getSocket(String value){
        return new InetSocketAddress(Integer.parseInt(value));
    }

}
