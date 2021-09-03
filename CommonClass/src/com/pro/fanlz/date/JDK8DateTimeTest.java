package com.pro.fanlz.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author fanlz
 * @description: TODO
 * @date 2021/9/1 17:20
 */
public class JDK8DateTimeTest {

    @Test
    public void test1(){
        //now
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of
        System.out.println(LocalDateTime.of(2021, 9, 1, 17, 24));

        //get
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        //with 有返回值
        System.out.println(localDate.withDayOfMonth(22));
        System.out.println(localDateTime.withDayOfYear(54));

        //plus\minus
        System.out.println(localDate.plusDays(10));
        System.out.println(localDate.minusDays(10));
    }


    @Test
    public void dataTimeFormatTest(){
        //方式一：
        // 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME;
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化 日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String str1 = isoLocalDateTime.format(now);
        System.out.println(now);
        System.out.println(str1);
        // 解析 字符串-->日期
        TemporalAccessor parse = isoLocalDateTime.parse(str1);
        System.out.println(parse);

        // 方式二：
        // 本地化相关格式。如：ofLocalizedDateTime()
        // FormatStyle
        //            .LONG
        //            .MEDIUM
        //            .SHORT
        // 适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        // 格式化
        String str2 = dateTimeFormatter.format(parse);
        System.out.println(str2);

        // 本地化相关格式。如：ofLocalizedDateTime()
        // FormatStyle
        //            .LONG
        //            .MEDIUM
        //            .SHORT
        // 适用于LocalDate

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String str3 = dateTimeFormatter1.format(LocalDate.now());
        System.out.println(str3);

        // 方式三： 自定义格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
        String format = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format);
    }




}
