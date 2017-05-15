package com.access.datasource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author andy
 * @create 2017-05-09 14:54
 */
@Configuration
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${elasticsearch.clusterName}")
    private String clusterName;
    @Value("${elasticsearch.ips}")
    private String ips;
    @Value("${elasticsearch.port}")
    private Integer port;

    @Bean(name = "client")
    public Client getESClient() {
        Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName)
                .put("client.transport.sniff", true).build();
        TransportClient client = TransportClient.builder().settings(settings).build();

        String[] ipArray = ips.split(",");
        for (String ip : ipArray) {
            try {
                InetAddress address = InetAddress.getByName(ip);
                client = client.addTransportAddress(new InetSocketTransportAddress(address, port));
            } catch (UnknownHostException e) {
                logger.info("{}",e);
            }
        }
        return client;
    }
}
