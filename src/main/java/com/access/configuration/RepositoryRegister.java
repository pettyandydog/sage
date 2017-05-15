package com.access.configuration;

import com.access.proxy.RepositoryProxyFactory;
import org.elasticsearch.client.Client;

/**
 * @author andy
 * @create 2017-05-10 16:39
 */
public class RepositoryRegister {

    public static Object register(Client client, String path){
        Class<?> repository = Resource.getInterface(path);
        RepositoryProxyFactory factory = new RepositoryProxyFactory(repository);
        return factory.newInstance(client);
    }
}
