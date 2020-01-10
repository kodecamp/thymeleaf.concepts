package in.kodecamp;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    resolver.addTemplateAlias("template", "./templates/common/template");
    resolver.addTemplateAlias("productutils", "./templates/common/product.util");
//    resolver.setTemplateMode(TemplateMode.TEXT);
//    resolver.setSuffix(".txt");
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setSuffix(".html");

    TemplateEngine engine = new TemplateEngine();
    engine.setTemplateResolver(resolver);

    // mutable writer
    Writer writer = new OutputStreamWriter(System.out);

    Context context = new Context();

    context.setVariable("pageTitle", "Home Page");
    context.setVariable("products", createProducts());

    // modifies the writer and inserts the processed template
    engine.process("productlist", context, writer);
  }

  private static List<Product> createProducts() {
    List<Product> products = new ArrayList<>();

    Product p1 = new Product();
    p1.setUrl("products/greenmouse.html");
    p1.setName("Green Mouse");
    p1.setPrice(100);

    Product p2 = new Product();
    p2.setUrl("products/whitemouse.html");
    p2.setName("White Mouse");
    p2.setPrice(200);

    Product p3 = new Product();
    p3.setUrl("products/whitekeyboard.html");
    p3.setName("White Keyboard");

    products.add(p1);
    products.add(p2);
    products.add(p3);

    return products;
  }
}
