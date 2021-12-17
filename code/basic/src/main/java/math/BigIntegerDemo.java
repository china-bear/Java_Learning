package math;

import com.google.common.primitives.UnsignedLong;

import java.math.BigInteger;

public class BigIntegerDemo {

    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789"); // 声明BigInteger对象
        BigInteger bi2 = new BigInteger("987654321"); // 声明BigInteger对象
        System.out.println("加法操作：" + bi2.add(bi1)); // 加法操作
        System.out.println("减法操作：" + bi2.subtract(bi1)); // 减法操作
        System.out.println("乘法操作：" + bi2.multiply(bi1)); // 乘法操作
        System.out.println("除法操作：" + bi2.divide(bi1)); // 除法操作
        System.out.println("最大数：" + bi2.max(bi1)); // 求出最大数
        System.out.println("最小数：" + bi2.min(bi1)); // 求出最小数
        BigInteger[] result = bi2.divideAndRemainder(bi1); // 求出余数的除法操作
        System.out.println("商是：" + result[0] + "；余数是：" + result[1]);

        // uint64转java的long，数据过大时会溢出方式一 com.google.common.primitive
        UnsignedLong unsignedLong1 = UnsignedLong.fromLongBits(Long.MIN_VALUE);
        System.out.println("Long.MIN_VALUE 正数 = " + unsignedLong1.toString());

        Long origin = UnsignedLong.valueOf(String.valueOf(unsignedLong1)).longValue();
        System.out.println("Long.MIN_VALUE is " + origin);

        UnsignedLong impressionid01 = UnsignedLong.fromLongBits(-8796894900267470104L);
        System.out.println("-8796894900267470104L = " + impressionid01.toString());

        Long impressionid02 = UnsignedLong.valueOf(String.valueOf("9649849173442081512")).longValue();
        System.out.println("9649849173442081512 = " + impressionid02);

        // uint64转java的long，数据过大时会溢出互转 方式二 Java8+ 自带Long.parseUnsignedLong()
        String id = "9649849173442081512";
        Long long1 = Long.parseUnsignedLong(id);
        System.out.println("id: " + id);

        id = "-8796894900267470104";
        Long longId = Long.parseLong(id);
        System.out.println("longId: " + Long.toUnsignedString(longId));

        System.out.println(Long.toUnsignedString(Long.parseLong(String.valueOf(-8796894900267470104L))));
        System.out.println(Long.toUnsignedString(Long.parseLong(String.valueOf(8796894900267470104L))));
    }

}
