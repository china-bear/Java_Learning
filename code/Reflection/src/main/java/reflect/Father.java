package reflect;

/**
 * Created by bear on 2020/9/4
 */
public class Father {

    public String FName;
    public int FAge;

    public Father() {
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public int getFAge() {
        return FAge;
    }

    public void setFAge(int FAge) {
        this.FAge = FAge;
    }

    public void printFatherMsg(){
        System.out.println("Father Class");
    }
}
