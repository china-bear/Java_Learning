package math;

public class FloatDoubleTest3 {
    public static void main(String[] args) {
        double d = 20014999;
        long l = Double.doubleToLongBits(d);
        System.out.println(Long.toBinaryString(l));
        float f = 20014999;
        int i = Float.floatToIntBits(f);
        System.out.println(Integer.toBinaryString(i));
    }
}

