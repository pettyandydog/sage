package com.access.execute.annotation;

import com.access.annotation.Index;
import com.access.annotation.Param;
import com.access.annotation.Query;
import com.access.annotation.Type;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author andy
 * @create 2017-05-12 17:16
 */
public class BaseAnnotationHandle implements AnnotationHandle {

    private Method method;
    public BaseAnnotationHandle(Method method){
        this.method = method;
    }
    @Override
    public String[] indexValue() {
        return method.getDeclaringClass().getAnnotation(Index.class).value();
    }

    @Override
    public String[] typeValue() {
        return method.getAnnotation(Type.class).value();
    }

    @Override
    public String queryValue() {
        return method.getAnnotation(Query.class).value();
    }

    @Override
    public String[] paramValue() {
        Parameter[] parameter = method.getParameters();
        if(null != parameter && parameter.length>0){
            int paramSize = parameter.length;
            String[] paramValue = new String[paramSize];
            for(int i =0; i<paramSize; i++){
                Param param = parameter[i].getAnnotation(Param.class);
                if(param == null){
                    // throw exception: parameter not use param annotation
                }
                paramValue[i] = param.value();
            }
            return paramValue;
        }
        return null;
    }
}
