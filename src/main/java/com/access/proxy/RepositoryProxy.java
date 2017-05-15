package com.access.proxy;

import com.access.execute.RepositoryExecute;
import org.elasticsearch.client.Client;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author andy
 * @create 2017-05-10 14:17
 */
public class RepositoryProxy implements InvocationHandler ,Serializable {

    private static final long serialVersionUID = -1L;

    private Client client;
    public RepositoryProxy(Client client){
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //todo add cache
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(proxy,args);
        }
        RepositoryExecute repositoryAction = new RepositoryExecute(method);
        return repositoryAction.execute(client,args);
    }
}
