package json;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import org.springframework.util.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class gsonTest01 {

    public static class User {
        //省略其它
        public String name;
        public int age;

        @SerializedName("email_address") //属性重命名
        public String emailAddress;

        public User(String name, int age, String emailAddress) {
            this.name = name;
            this.age = age;
            this.emailAddress = emailAddress;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", emailAddress='" + emailAddress + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 直接使用Gson构造方法创建；
        Gson gson = new Gson();
       // Gson gson = new GsonBuilder().create(); 使用GsonBuilder创建  GsonBuilder创建的方式更灵活，因为它支持对Gson的配置

        // 基本数据类型的解析
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
        System.out.println(str);

        // 基本数据类型的生成
        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"
        System.out.println(jsonNumber);
        System.out.println(jsonBoolean);
        System.out.println(jsonString);

        //POJO类的生成
        User user = new User("海盗",24, "one@two.com");
        String jsonObject = gson.toJson(user); // {"name":"海盗","age":24}
        System.out.println(jsonObject);
        System.out.println(jsonObject);

        //POJO类的解析
        String jsonStr = "{\"name\":\"海盗\",\"age\":24}";
        User user1 = gson.fromJson(jsonStr, User.class);
        System.out.println(user1);
        System.out.println(user1.getName());

        // 等价下面  下面二种 https://stackoverflow.com/questions/5128442/how-to-convert-a-string-to-jsonobject-using-gson-library/39636232
        // https://www.jianshu.com/p/e740196225a4
        // https://www.jianshu.com/p/91dc4033e733

        JsonObject convertedObject = new Gson().fromJson(jsonStr, JsonObject.class);
        System.out.println(convertedObject);
        System.out.println(convertedObject.get("name").getAsString());

        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(jsonStr);
        Assert.notNull(jo);
        System.out.println(jo.get("age").getAsInt());

        //1 .使用Java创建JSON数据
        //创立JSON对象
        JsonObject read_object = new JsonObject();
        //添加键值对
        read_object.addProperty("cat","it");

        //添加数组
        JsonArray array1 = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id",1);
        lan1.addProperty("name","Java");
        lan1.addProperty("ide","Eclipse");
        array1.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id",2);
        lan2.addProperty("name","Swift");
        lan2.addProperty("ide","XCode");
        array1.add(lan2);

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id",3);
        lan3.addProperty("name","C#");
        lan3.addProperty("ide","Visual Studio");
        array1.add(lan3);
        //将这个数组添加进去
        read_object.add("languages",array1);
        //添加布尔
        read_object.addProperty("pop", true);
        //输出
        System.out.println(read_object.toString());
        System.out.println(read_object.get("languages"));

        // 2. 读取JSON数据
        try{
            //建立一个JSON的解析器
            //可用解析器解析字符串或者输入流
            JsonParser parser = new JsonParser();
            //建立一个JSON对象
            JsonObject object = (JsonObject) parser.parse(new FileReader("E:\\CodeRepository\\Chinabear\\Java_Learning\\code\\basic\\src\\main\\resources\\test.json"));
            //读取对象值
            //由键索引键值，并依据键值数据类型，转换其格式
            System.out.println("cat=" + object.get("cat").getAsString());
            System.out.println("pop=" + object.get("pop").getAsBoolean());

            //读取数组
            JsonArray array = object.get("languages").getAsJsonArray();
            for (int j =0; j< array.size(); j++){
                System.out.println("-----------");
                JsonObject subobject = array.get(j).getAsJsonObject();
                System.out.println("id=" + subobject.get("id").getAsInt());
                System.out.println("name=" + subobject.get("name").getAsString());
                System.out.println("ide=" + subobject.get("ide").getAsString());
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
