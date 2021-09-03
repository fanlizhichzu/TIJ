package com.pro.fanlz.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fanlz
 * @description: SimpleDateFormat
 * jdk8 之前的日期时间的API测试
 * 1.System类中currentTimeMillis()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @date 2021/9/1 16:20
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    1、两个操作
    1.1、格式化：日期--->字符串
    1.2、解析：格式化的逆过程，字符串--->日期

    2、SimpleDateFormat的实例化
     */

    @Test
    public void simpleDateFormatTest() throws ParseException {
        // 实例化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        // 格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = simpleDateFormat.format(date);
        System.out.println(format);

        // 解析 格式化的逆过程，字符串--->日期
        String str = "21-9-1 下午4:29";
        Date parse = simpleDateFormat.parse(str);
        System.out.println(parse);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String format1 = dateFormat.format(date);
        System.out.println(format1);

        System.out.println(dateFormat.parse("2021-36-01 04:36:37"));


    }
}
