package exception;

public class ExceptionTest {

    // try-catch
    public static void test01() {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e) {
            i = 20;
        }
        System.out.println(i);
    }

    // 多个 single-catch 块的情况

    public static void test02() {
        int i = 0;
        try {
            i = 10;
        } catch (ArithmeticException e) {
            i = 30;
        } catch (NullPointerException e) {
            i = 40;
        } catch (Exception e) {
            i = 50;
        }
        System.out.println(i);
    }

    //finally
    public static void test03() {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e) {
            i = 20;
        } finally {
            i = 30;
        }
        System.out.println(i);
    }

    public static int test04() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    //如果在 finally 中出现了 return，会吞掉异常,
    public static int test05() {
        try {
            int i = 1/0;
            return 10;
        } finally {
            return 20;
        }
    }

    public static int test06() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
        }
    }

    public static void main(String[] args) {

        //
        test01();
        //
        test02();
        //
        test03();

        //
        System.out.println(test04());

        System.out.println(test05());

        System.out.println(test06());
    }
}
