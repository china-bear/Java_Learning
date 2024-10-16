package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo05 {

    public static void main(String[] args) {
        Properties pro = new Properties();    // 创建Properties对象
        File file = new File("D:" + File.separator + "area.xml");    // 指定要操作的文件
        try {
            pro.loadFromXML(new FileInputStream(file));    // 读取属性文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1、BJ属性存在：" + pro.getProperty("BJ"));
    }

}
