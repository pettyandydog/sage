package com.access.execute.statement;

import com.access.exception.SageException;
import com.access.execute.ParamPlaceholder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author andy
 * @create 2017-05-12 15:53
 */
public class BaseStatementHandle implements StatementHandle {

    private String statement;
    public BaseStatementHandle(String statement){
        this.statement = statement;
    }

    @Override
    public String statementReplace(String[] paramName, Object[] params){
        Map<String,Object> loaner = paramHandle(paramName,params);
        String replaceStatement = statement;
        for(Map.Entry<String,Object> entry:loaner.entrySet()){
            String placeholder = new StringBuilder(ParamPlaceholder.PREFIX.placeholder).append(entry.getKey()).append(ParamPlaceholder.SUFFIX.placeholder).toString();
            String value = String.valueOf(entry.getValue());
            replaceStatement = replaceStatement.replace(placeholder,value);
        }
        return replaceStatement;
    }

    private Map<String,Object> paramHandle(String[] paramName, Object[] params) {
        if(params.length > paramName.length){
            throw new SageException("no param annotation !!!");
        }
        Map<String,Object> paramMap = new ConcurrentHashMap();
        int paramSize = params.length;
        for(int i=0; i<paramSize; i++){
            paramMap.put(paramName[i],params[i]);
        }
        return paramMap;
    }
}
