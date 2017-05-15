package com.access.execute;

import com.access.execute.annotation.AnnotationHandle;
import com.access.execute.annotation.BaseAnnotationHandle;
import com.access.execute.statement.BaseStatementHandle;
import com.access.execute.statement.StatementHandle;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author andy
 * @create 2017-05-10 16:56
 */
public class RepositoryExecute {

    private static Logger logger = LoggerFactory.getLogger(RepositoryExecute.class);

    private final Method method;

    public RepositoryExecute(Method method){
        this.method = method;
    }

    public Object execute(Client client, Object[] args){
        AnnotationHandle annotationHandle =  new BaseAnnotationHandle(method);
        String[] indexes = annotationHandle.indexValue();
        String[] types = annotationHandle.typeValue();
        String query = annotationHandle.queryValue();
        String queryStatement = format(query,annotationHandle.paramValue(),args);
        logger.info("query statement: ->{}",queryStatement);
        return search(client,indexes,types,queryStatement);
    }

    private String format(String query, String[] paramName, Object[] args){
        if(null != args && args.length>0){
            StatementHandle statementHandle = new BaseStatementHandle(query);
            return statementHandle.statementReplace(paramName,args);
        }
        return query;
    }

    private Map<String,Object> search(Client client, String[] indexes, String[] types, String queryStatement){
        SearchResponse response = client
                .prepareSearch(indexes)
                .setTypes(types)
                .setQuery(queryStatement)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .get();
        Map resultMap = new ConcurrentHashMap();
        resultMap.put("result",response);
        return resultMap;
    }

}
