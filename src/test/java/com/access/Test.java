package com.access;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

/**
 * @author andy
 * @create 2017-05-11 17:23
 */
public class Test {

    public static void main(String[] args){


        //System.out.println(cf.format(0));

       // MessageFormat.
        //String result = MessageFormat.format("\"query\" : {\"match\" : {\"WPBH\" : #{0}  }}","804236775636");
        String s = "\"query\" : {\"match\" : {\"WPBH\" : #{0}  }}";
        String news = s.replace("#{0}","ss");
        System.out.println(news);

       /* String pattern = "{0}#{1}|{1}#{2}|{2}#{3}|{3}#{4}";
        ChoiceFormat format = new ChoiceFormat(pattern);
        //输出的结果是
        // 0=[0,3)|1=[0,3)|2=[0,3)|3=[3,6)|4=[3,6)|5=[3,6)|6=[6,9)|7=[6,9)|8=[6,9)|9=[9]|
        for(int i=0;i<4;i++){
            System.out.println(i+"="+format.format("{"+i+"}")+"|");
        }*/
    }
}
