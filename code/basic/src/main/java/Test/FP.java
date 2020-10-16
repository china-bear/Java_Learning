package Test;

import java.math.BigDecimal;

/**
 * 浮点数运算精度问题
 * https://mp.weixin.qq.com/s/rkepSobah40nM5AouHz1CA
 * https://zhuanlan.zhihu.com/p/74108078
 */
public class FP {

    public void testFloat(){
        float a = 1.1f;
        float b = 0.8f;
        System.out.println("a-b = "+(a-b));
        System.out.println("a+b = "+(a+b));
        System.out.println("a*b = "+(a*b));
        System.out.println("a/b = "+(a/b));
    }

    // Double 类型
    public void testDouble(){
        double a = 1.1;
        double b = 0.8;
        System.out.println("a-b = "+(a-b));
        System.out.println("a+b = "+(a+b));
        System.out.println("a*b = "+(a*b));
        System.out.println("a/b = "+(a/b));
    }


    // BigDecmial 错误使用 BigDecimal 应该使用 String 构造函数，禁止使用double构造函数
    public void testBigDecimal(){
        BigDecimal a = new BigDecimal(1.1);
        BigDecimal b = new BigDecimal(0.8);
        System.out.println("a-b = "+(a.subtract(b)));
        System.out.println("a+b = "+(a.add(b)));
        System.out.println("a*b = "+(a.multiply(b)));
        System.out.println("a/b = "+(a.divide(b)));
    }

    public void testBigDecimalStripZeros(){
        BigDecimal b = new BigDecimal("0.000000100000000");
        System.out.println(b.stripTrailingZeros().toString());
        System.out.println(b.stripTrailingZeros().toPlainString());
    }

    // BigDecmial 正确使用
    public void testBigDecimalNormal(){
        BigDecimal a = new BigDecimal("1.1");
        BigDecimal b = new BigDecimal("0.8");
        System.out.println("a-b = "+(a.subtract(b)));
        System.out.println("a+b = "+(a.add(b)));
        System.out.println("a*b = "+(a.multiply(b)));
        System.out.println("a/b = "+(a.divide(b)));
    }

    public static void main(String[] args) {
        FP fp = new FP();
        fp.testFloat();
        System.out.println("----------------------------");
        fp.testDouble();
        System.out.println("----------------------------");
        fp.testBigDecimalNormal();
        System.out.println("----------------------------");
        fp.testBigDecimalStripZeros();
        System.out.println("----------------------------");
        fp.testBigDecimal();

    }
}
