package com.pro.fanlz.date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author fanlz
 * @description: TODO
 * @date 2021/9/1 17:40
 */
public class InstantTest {
    @Test
    public void test(){
        // now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
        System.out.println(instant.toEpochMilli());

        System.out.println(Instant.ofEpochMilli(1630546870500L));
    }
}
