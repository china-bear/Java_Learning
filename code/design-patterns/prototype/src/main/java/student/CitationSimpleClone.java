package student;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Citation
 * @Description: 奖状
 * @Author: 黑马程序员
 */
public class CitationSimpleClone implements Cloneable {

    private String rank;

    private Student stu;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    @Override
    public CitationSimpleClone clone() throws CloneNotSupportedException {
        return (CitationSimpleClone) super.clone();
    }

    public void show() {
        System.out.println(Color.BLUE + stu.getName() + Color.RESET + ":\n\t在2021学年第一学期中表现优秀，荣获" + Color.RED +  getRank()  + Color.RESET + "!");
    }
}
