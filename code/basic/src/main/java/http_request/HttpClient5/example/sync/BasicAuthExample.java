package http_request.HttpClient5.example.sync;


import http_request.HttpClient5.utils.HttpClientUtil;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * HttpClient Basic Auth 验证示例
 */

public class BasicAuthExample {

    /**
     * Basic Auth 访问验证测试
     */

    private static final Logger logger = LoggerFactory.getLogger(BasicAuthExample.class);
    public static void httpBasicAuth() {
        CloseableHttpResponse response = null;
        // 配置 Credentials
        HttpClientUtil.getBasicCredentialsProvider().setCredentials(
                new AuthScope("localhost", 8080),
                new UsernamePasswordCredentials("admin", "123456".toCharArray()));
        try {
            // 创建 Http 请求
            HttpGet httpget = new HttpGet("http://localhost:8080/basic/test");
            // 执行 Http 请求，进行登录
            response = HttpClientUtil.getHttpclient().execute(httpget);
            // 输出响应内容
            if (response.getEntity() != null) {
                logger.info(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
            }
            // 销毁流
            EntityUtils.consume(response.getEntity());
        } catch (IOException | ParseException e) {
            logger.error("", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }
        }
    }

    /** 测试 Main 方法 */
    public static void main(String[] args) {
        // 访问需要 BasicAuth 验证的地址，进行测试
        httpBasicAuth();
    }

}
