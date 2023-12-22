package math;


import java.math.BigDecimal;

/**
 * 浮点数运算精度问题
 *
 * https://abingsky37.github.io/float_lost.html 浮点数精度为什么会丢失（java示例）
 * https://cloud.tencent.com/developer/article/1470383
 * 任何一个浮点数字，在底层表示都必须转换成这种科学计数法来表示，那么我们来想想看什么时候这个数字会无法表示呢？那么只有两种情形：
 * 幂数不够表示了：这种情况往往出现在数字太大了，超过幂数所能承受的范围，那么这个数字就无法表示了。如幂数最大只能是10，但是这个数字用科学计数法表示时，幂数一定会超过10，就没办法了。
 * 尾数不够表示了：这种情况往往出现在数字精度太长了，如1.3434343233332这样的数字，虽然很小，还不超过2，这种情况下幂数完全满足要求，但是尾数已经不能表示出来了这么长的精度。
 *
 * 浮点运算很少是精确的，只要是超过精度能表示的范围就会产生误差。往往产生误差不是因为数的大小，而是因为数的精度。因此，产生的结果接近但不等于想要的结果。尤其在使用 float 和 double 作精确运算的时候要特别小心。
 * 可以考虑采用一些替代方案来实现。如通过 String 结合 BigDecimal 或者通过使用 long 类型来转换。
 */


public class FloatDoubleTest {
    public static void main(String[] args) {
        float f = 20014999;
        double d = f;
        double d2 = 20014999;
        System.out.println("f=" + f);
        System.out.println("d=" + d);
        System.out.println("d2=" + d2);

        double a1=0.3;
        BigDecimal bigDecimal1 = new BigDecimal(a1);
        BigDecimal bigDecimal2 = new BigDecimal("0.3");

        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);

    }
}