package com.pro.fanlz.String;

import org.junit.jupiter.api.Test;

/**
 * @author fanlz
 * @description: StringBuffer\StringBuilder
 * @date 2021/9/1 10:32
 */
public class StringBufferBuilderDemo {
    /*
    String、StringBuffer、StringBuilder三者异同
    String:不可变的字符序列 底层使用char[]存储
    StringBuffer:可变的字符序列，线程是安全的，效率低 底层使用char[]存储
    StringBuilder：可变的字符序列，线程不安全，效率高，底层使用char[]存储


    源码分析：
    // char[] value = new char[0];
    String str = new String();
    // char[] value = new char[]{'a','b','c'};
    String str1 = new String("abc")

    // char[] value = new char[16];
    // 底层创建了一个长度是16的char数组
    StringBuffer sb1 = new StringBuffer();
    sb1.append('a'); // value[0] = 'a';
    sb1.append('b'); // value[1] = 'b';

    // char[] value = new char["abc".length() + 16]
    StringBuffer sb2 = new StringBuffer("abc");

    // 问题2 扩容问题：
    如果要添加的数据底层数组放不下，默认情况下，扩容为原来的2倍+2，同时将原有数组中的元素复制到新的数组中

    总结：
    append()
    delete()
    setCharAt() / replace()
    charAt()
    insert()
    length()


    */

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.insert(2,"def");
        s1.replace(0,2, "mav");
        s1.reverse();
        System.out.println(s1);
    }
}
