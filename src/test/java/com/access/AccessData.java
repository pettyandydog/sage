package com.access;

import com.access.configuration.RepositoryRegister;
import com.access.repository.EsRepository;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.Map;

/**
 * @author andy
 * @create 2017-05-09 16:28
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AccessData {
    private static Logger logger = LoggerFactory.getLogger(AccessData.class);

    @Autowired
    private Client client;

    @Test
    public void testProxy(){
        EsRepository esMapper = (EsRepository) RepositoryRegister.register(client, "com.access.repository.EsRepository");
        Map<String,Object> result = esMapper.getPerson();
        logger.info("{}",result);
    }

    @Test
    public void testParam(){
        EsRepository esMapper = (EsRepository) RepositoryRegister.register(client, "com.access.repository.EsRepository");
        Map<String,Object> result = esMapper.getPerson2("623539090156");
        logger.info("{}",result);
    }
}
