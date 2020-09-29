package reflect;

/**
 * Created by bear on 2020/9/4
 */
public class Son extends Father {

    private String Name;
    protected int  Age;
    public String Birthday;

    private String MSG = "Original";

    //String 会被 JVM 优化,  反射修改后 运行还是原始值
    // 并不是所有常量都会优化。经测试对于 int 、long 、boolean 以及 String 这些基本类型 JVM 会优化，而对于 Integer 、Long 、Boolean 这种包装类型，或者其他诸如 Date 、Object 类型则不会被优化。
    private final String FINAL_VALUE1 = "FINAL1";

    // 将赋值放在三目表达式中，运行结果反射修改成功
    private final String FINAL_VALUE2 = null == null ? "FINAL2" : null;;

    // 将赋值放在构造函数中，运行结果反射修改成功, 这就不测试了

    public Son() {
    }

    public Son(String name, int age, String birthday) {
        Name = name;
        Age = age;
        Birthday = birthday;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    private String getBirthday() {
        return Birthday;
    }

    private void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public String getFinalValue1() {
        // 会被优化为: return "FINAL"
        return FINAL_VALUE1;
    }

    public String getFinalValue2() {
        // 会被优化为: return "FINAL"
        return FINAL_VALUE2;
    }

    @Override
    public String toString() {
        return "Son{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Birthday='" + Birthday + '\'' +
                ", FName='" + FName + '\'' +
                ", FAge=" + FAge +
                '}';
    }

    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + Name + "; age : " + Age);
    }

    private void privateMethod(String head , int tail){
        System.out.println(head + tail);
    }

}
