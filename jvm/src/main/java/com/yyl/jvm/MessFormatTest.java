package com.yyl.jvm;

import java.text.MessageFormat;

/**
 * Created by yuanyunl on 2017/8/4.
 */
public class MessFormatTest {

    public static void main(String[] args){
        String str = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";
        Object[] array = new Object[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};
        String value = MessageFormat.format(str, array);
        System.out.println(value);
    }
}
