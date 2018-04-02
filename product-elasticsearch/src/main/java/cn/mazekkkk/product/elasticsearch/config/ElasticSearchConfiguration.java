package cn.mazekkkk.product.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetSocketAddress;

/**
 * es配置
 *
 * @author maze
 * @createTime 18/3/30
 */
@Configuration
@EnableJpaRepositories(basePackages = "cn.mazekkkk.product.elasticsearch.repository")
public class ElasticSearchConfiguration {

    /**
     * 直接操作Elasticsearch
     * @return
     */
    @Bean
    public TransportClient getTransPortClient(ElasticSearchConfiguration elasticSearchConfiguration){
        Settings settings = Settings.settingsBuilder().put("client.transport.ignore_cluster_name", "true").build();
        TransportClient transportClient = TransportClient.builder().settings(settings).build();

        TransportAddress transportAddress = new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1",9300));
        transportAddress.getAddress();
        transportClient.addTransportAddress(transportAddress);
        return transportClient;
    }



}
