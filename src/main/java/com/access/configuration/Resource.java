package com.access.configuration;

import com.access.annotation.Index;
import org.reflections.Reflections;

import java.util.Set;

/**
 * 读取接口信息
 * @author andy
 * @create 2017-05-10 15:25
 */
public class Resource {

    protected static Set<Class<?>> getInterfaces(String path){
        Reflections reflections = new Reflections(path);
        return reflections.getTypesAnnotatedWith(Index.class);
    }

    protected static Class<?> getInterface(String path){
        try {
            return Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
