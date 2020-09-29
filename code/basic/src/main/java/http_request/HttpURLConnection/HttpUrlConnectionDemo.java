package http_request.HttpURLConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 测试 HttpURLConnection， 不支持 HTTP/2
 * 在 Java 9 中，官方在标准库中引入了一个 high level、支持 HTTP/2 的 HttpClient
 * https://liudanking.com/sitelog/java-http-client-lib-comparison/
 */
public class HttpUrlConnectionDemo {

    public static void getMethod() throws IOException {
        URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=101.202.10.149");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置连接超时时间
        connection.setConnectTimeout(15000);
        // 设置读取超时时间
        connection.setReadTimeout(15000);

        // 设置请求参数，即具体的 HTTP 方法
        connection.setRequestMethod("GET");

        // 添加 HTTP HEAD 中的一些参数，可参考《Java 核心技术 卷II》
        connection.setRequestProperty("Connection", "Keep-Alive");
        // 设置是否使用缓存
        connection.setUseCaches(true);
        // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
        connection.setInstanceFollowRedirects(true);
        // 设置是否向 httpUrlConnection 输出，
        // 对于post请求，参数要放在 http 正文内，因此需要设为true。
        // 默认情况下是false;
        connection.setDoOutput(false);
        // 设置是否从 httpUrlConnection 读入，默认情况下是true;
        connection.setDoInput(true);

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            // // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("rsp:" + sb.toString());
            // 断开连接，释放资源
            connection.disconnect();
        } else {
            System.out.println("rsp code:" + connection.getResponseCode());
        }
    }

    public static void postMethod() throws IOException {
        URL url = new URL("http://ip.taobao.com/ipSearch");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置连接超时时间
        connection.setConnectTimeout(15000);
        // 设置读取超时时间
        connection.setReadTimeout(15000);

        // 设置请求参数，即具体的 HTTP 方法
        connection.setRequestMethod("GET");
        // 伪装成浏览器
        connection.setRequestProperty("user-agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
        //  设置使用标准编码格式编码参数的名-值对
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 添加 HTTP HEAD 中的一些参数，可参考《Java 核心技术 卷II》
        connection.setRequestProperty("Connection", "Keep-Alive");
        // 设置是否使用缓存
        connection.setUseCaches(false);
        // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
        connection.setInstanceFollowRedirects(true);

        // 设置是否向 httpUrlConnection 输出，
        // 对于post请求，参数要放在 http 正文内，因此需要设为true。
        // 默认情况下是false;
        connection.setDoOutput(true);
        // 设置是否从 httpUrlConnection 读入，默认情况下是true;
        connection.setDoInput(true);

        // 利用 getOutputStream() 传输 POST 消息，POST 消息才需要写数据，GET 不需要。
        // getOutputStream 和 getInputStream 会隐式的调用 connect()
        String params = "202.101.224.69";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        writer.write(params);
        writer.flush();
        writer.close();
        System.out.println(writer == null);

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            // 从流中读取响应信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("rsp:" + sb.toString());
            // 断开连接，释放资源
            connection.disconnect();
            System.out.println(reader == null);
        } else {
            System.out.println("rsp code:" + connection.getResponseCode());
        }
    }

    public static void main(String[] args) throws IOException {
        getMethod();
        System.out.println("-------------------------------");
        postMethod();
    }
}
