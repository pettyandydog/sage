package com.access.execute.statement;

import java.util.Map;

/**
 * @author andy
 * @create 2017-05-12 14:12
 */
public interface StatementHandle {

    String statementReplace(String[] paramName, Object[] params);

}
