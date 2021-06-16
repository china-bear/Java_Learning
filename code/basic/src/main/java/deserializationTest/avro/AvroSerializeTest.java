package deserializationTest.avro;

import com.google.common.io.Resources;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class AvroSerializeTest {
    public static void main(String[] args) throws IOException {

        // 方法一 通过avro-maven-plugin 或 avro-tools 生成avro的java类 序列化和反序列化  https://avro.apache.org/docs/1.8.2/gettingstartedjava.html#download_install

        //  1. Creating Users
        User user1 = new User();
        user1.setName("胡一刀");
        user1.setAge(36);
        user1.setSalary(18000.8);

        User user2 = new User("韦小宝", 23, 1000.50);

        User user3 = User.newBuilder()
                .setName("李白")
                .setAge(52)
                .setSalary(829.000)
                .build();

        File file = new File("users.avro");

        // 2. Serialize user1, user2 and user3 to disk
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user1.getSchema(), file);
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.append(user3);
        dataFileWriter.close();

        // 3. Deserialize Users from disk
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(file, userDatumReader);
        User user = null;
        while (dataFileReader.hasNext()) {
        // Reuse user object by passing it to next(). This saves us from
        // allocating and garbage collecting many objects for files with
        // many items.
            user = dataFileReader.next(user);
            System.out.println(user);
        }

        // 方法二   不生成avro的java类文件 直接序列化和反序列化  https://avro.apache.org/docs/1.8.2/gettingstartedjava.html#download_install
        //Serializing and deserializing without code generation
        // 1. 获取类路径下 avsc 文件路径
        String file_path = Resources.getResource("avro/user.avsc").getPath(); //com.google.common.io.Resources class

        //  2. Creating Users
        Schema schema = new Schema.Parser().parse(new File(file_path));
        GenericRecord user4 = new GenericData.Record(schema);
        user4.put("name", "Alyssa");
        user4.put("age", 60);
        // Leave salary null
        GenericRecord user5 = new GenericData.Record(schema);
        user5.put("name", "Ben");
        user5.put("age", 7);
        user5.put("salary", 6000.00);

        // 3. Serialize user4 and user5 to disk
        File file2 = new File("users2.avro");
        DatumWriter<GenericRecord> datumWriter2 = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter2 = new DataFileWriter<GenericRecord>(datumWriter2);
        dataFileWriter2.create(schema, file2);
        dataFileWriter2.append(user4);
        dataFileWriter2.append(user5);
        dataFileWriter2.close();

        // 4. Deserialize users from disk
        DatumReader<GenericRecord> datumReader2 = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader2 = new DataFileReader<GenericRecord>(file2, datumReader2);
        GenericRecord genUser = null;
        while (dataFileReader2.hasNext()) {
        // Reuse user object by passing it to next(). This saves us from allocating and garbage collecting many objects for files with many items.
            genUser = dataFileReader2.next(genUser);
            System.out.println(genUser);
        }
    }
}
