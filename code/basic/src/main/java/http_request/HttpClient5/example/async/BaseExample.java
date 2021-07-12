package http_request.HttpClient5.example.async;


import http_request.HttpClient5.utils.HttpClientAsycnUtil;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequests;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * HttpClient 异步请求基本操作示例
 * https://github.com/my-dlq/blog-example/tree/master/java/java-httpclient-example
 */

public class BaseExample {

    /**
     * Http 异步请求
     */

    private static final Logger logger = LoggerFactory.getLogger(http_request.HttpClient5.example.sync.BaseExample.class);

    public static void asyncRequest() {
        try {
            HttpHost httpHost = new HttpHost("http","localhost",8080);
            SimpleHttpRequest simpleHttpRequest = SimpleHttpRequests.create(Method.GET,httpHost,"/base/get?name=test&sex=man");
            final Future<SimpleHttpResponse> future = HttpClientAsycnUtil.getHttpclient()
                    .execute(simpleHttpRequest, new FutureCallback<SimpleHttpResponse>() {

                        @Override
                        public void completed(final SimpleHttpResponse response) {
                            logger.info(response.toString());
                        }

                        @Override
                        public void failed(final Exception ex) {
                            logger.error("执行请求失败：", ex);
                        }

                        @Override
                        public void cancelled() {
                            logger.info("取消请求");
                        }

                    });
            String responseBody = future.get().getBody().getBodyText();
            logger.info(responseBody);
        } catch (ExecutionException | InterruptedException e) {
            logger.error("", e);
            Thread.currentThread().interrupt();
        }
    }

    /** 测试 Main 方法 */
    public static void main(final String[] args) {
        asyncRequest();
    }

}
