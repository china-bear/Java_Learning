package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// JAVA中的四种JSON解析方式详解  https://zhuanlan.zhihu.com/p/344360857
public class jsonTest02 {

    public static void main(String[] args) {
        // 第一种. JSON官方
        // 1.1 Creating JSON Directly from JSONObject
        JSONArray pets = new JSONArray();
        pets.put("cat");
        pets.put("dog");
        JSONObject person = new JSONObject();
        person.put("name", "John Brown");
        person.put("age", 35);
        person.put("pets", pets);
        System.out.println(person.toString(2));

        // 1.2 Creating JSON from Map
        Map<String, String> map = new HashMap<>();
        map.put("name", "jon doe");
        map.put("age", "22");
        map.put("city", "chicago");
        JSONObject jo1 = new JSONObject(map);
        System.out.println(jo1.toString(2));
        System.out.println(jo1.getString("name"));

        // 1.3 Creating JSONObject from JSON String
        String jsonString  = "{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}";
        JSONObject jo2 = new JSONObject(jsonString);
        System.out.println(jo2.toString(2));
        System.out.println(jo2.getString("name"));  //根据key返回
        //System.out.println(jo2.getInt("noKey"));  ////根据key返回,如果没有抛出异常 JSONException: JSONObject["noKey"] not found.
        System.out.println(jo2.optInt("noKey"));  ////根据key返回,如果没有带缺省值 0
        System.out.println("是否空：" + jo2.isEmpty() +", key是否存在："+ jo2.isNull("test")); // 判断对象是否为空

        // 1.4 Serialize Java Object to JSON    Cat 类不能放在同一文件 或者JSON 为 NULL
        Cat cat = new Cat(1, "小猫",true );
        System.out.println(cat.toString());

        JSONObject jo3 =  new JSONObject(cat);
        System.out.println(jo3.toString(2));
        System.out.println(jo3.getString("name"));  ////根据key返回

        // 1.5 JavaBean与json字符串互转


        // JSONArray
        // 1.6  Creating JSONArray Directly from JSONObject
        JSONArray ja1 = new JSONArray();
        ja1.put(Boolean.TRUE);
        ja1.put("lorem ipsum");

        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");

        ja1.put(jo);
        ja1.put(jo1);
        System.out.println(ja1.toString(2));

        // 1.7  Creating JSONArray Directly from JSON String
        JSONArray ja2= new JSONArray("[true, \"lorem ipsum\", 215]");
        System.out.println(ja2.toString(2));

        // 1.8 Creating JSONArray Directly from a Collection or an Array
        List<String> list = new ArrayList<>();
        list.add("California");
        list.add("Texas");
        list.add("Hawaii");
        list.add("Alaska");

        JSONArray ja3 = new JSONArray(list);
        System.out.println(ja3.toString(2));

        // 1.9 JSONArray 遍历

        String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]" ; // 一个未转化的字符串
        // 首先把字符串转成 JSONArray  对象
        JSONArray jsonArray = new JSONArray(str);
        if(jsonArray.length()>0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = jsonArray.getJSONObject(i);
                // 得到 每个对象中的属性值
                System.out.println(job.get("name") + "=" + job.get("value"));
            }
        }
        // 第二种. 谷歌 Gson https://developer.aliyun.com/article/635057
        // 第三种. 阿里巴巴 FastJson
        // 第四种. Jackson
        // 第五种. JSON Library  net.sf.json-lib  2010就没有更新
    }
}


