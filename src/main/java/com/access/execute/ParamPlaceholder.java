package com.access.execute;

/**
 * @author andy
 * @create 2017-05-12 15:57
 */
public enum ParamPlaceholder {

    PREFIX("%{"),
    SUFFIX("}");

    public String placeholder;
    ParamPlaceholder(String placeholder){
        this.placeholder = placeholder;
    }

}
