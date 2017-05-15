package com.access.proxy;

import org.elasticsearch.client.Client;

import java.lang.reflect.Proxy;

/**
 * @author andy
 * @create 2017-05-10 16:48
 */
public class RepositoryProxyFactory<T> {

    private final Class<T> proxyInterface;

    public RepositoryProxyFactory(Class<T> proxyInterface){
        this.proxyInterface = proxyInterface;
    }

    public Object newInstance(Client client){
        final RepositoryProxy repositoryProxy = new RepositoryProxy(client);
        return newInstance(repositoryProxy);
    }

    private Object newInstance(RepositoryProxy repositoryProxy){
        return Proxy.newProxyInstance(proxyInterface.getClassLoader(),new Class[]{proxyInterface},repositoryProxy);
    }
}
