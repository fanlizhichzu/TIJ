package com.pro.fanlz.String;

/**
 * @author fanlz
 * @description: TODO
 * @date 2021/9/1 9:54
 */
public class StringCreate {
    public static void main(String[] args) {
        test1();
        System.out.println("************************");
        test2();
    }
    public static void test1(){
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3 == s4);
    }

    public static void test2(){
        String s1 = "javaEEHadoop";
        String s2 = "javaEE";
        String s3 = s2 + "Hadoop";

        System.out.println(s1==s3);

        final String s4 = "javaEE";
        String s5 = s4 + "Hadoop";
        System.out.println(s1==s5);

        // 返回值得到的s6使用的常量值中已经存在的"javaEE"
        String s6 = s3.intern();
        System.out.println(s6==s5);
    }

}
