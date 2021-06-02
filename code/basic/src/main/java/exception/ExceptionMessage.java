package exception;

// https://www.includehelp.com/java/different-ways-to-print-exception-message-in-java.aspx
public class ExceptionMessage {

/** 1. printStackTrace() method
    This method is available in the package java.lang.Throwable.printStackTrace().
    This method provides exception related information and we will see which information this method will provide.
    Name of the Exception
    Description of the Exception
    Stack Trace of the Exception
 */
    public static void PrintStackTrace() {
        Object obj = null;

        try {
            System.out.println(obj.toString());
        } catch (Exception ex) {
            /*Display exception name : exception description
            Stack trace */
            ex.printStackTrace();
        }
    }


/** 2. toString() method
    This method is available in the package java.lang.Throwable.toString().
    This method also provides exception related information and we will see again which information this method will provide.
    Name of the Exception
    Description of the Exception
 */
    public static void  ToStringMethod() {

        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception ex) {
            // Display exception name : exception description
            System.out.println(ex.toString());
        }
    }


/** 3. getMessage() method
    This method is also available in the package java.lang.Throwable.printStackTrace().
    This method provides exception related information and we will see which information this method will provide.
    Description of the Exception
    This method does not provide other information like exception name and exception stack trace.
 */
    public static void GetMessageMethod () {

        try {
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception ex) {
            // Display exception description
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("====== printStackTrace() =======");
        PrintStackTrace();
        System.out.println("======  ToStringMethod() =======");
        //ToStringMethod();
        System.out.println("====== GetMessageMethod() =======");
        //GetMessageMethod ();
    }
}
