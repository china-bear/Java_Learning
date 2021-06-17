package template_engine;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

/** Java中使用velocity实现模板渲染
 * https://www.jianshu.com/p/bcba20eeab48
 * https://www.javaguides.net/2019/01/top-java-template-engines.html
 * https://juejin.cn/post/6844904177949212686
 */

public class VelocityTest01 {

    private static final String VM_PATH = "template/velocity/hello.vm";  // vm文件中定义变量，从而进行模板输出

    public static void main(String[] args) {

        // 初始化模板引擎
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        // 获取模板文件
        Template template = velocityEngine.getTemplate(VM_PATH);

        // 设置变量，velocityContext是一个类似map的结构
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name", "Mike");
        velocityContext.put("world", "China");

        // 输出渲染后的结果
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
