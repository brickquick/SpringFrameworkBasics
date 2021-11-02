package quick.brick;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        List<Product> products = new ArrayList<>(10);
        resp.getWriter().printf("<ol>");
        for (int i = 1; i <= 10; i++) {
            products.add(new Product(i, "product-" + i, BigDecimal.valueOf(Math.random() * 1000000)));
            resp.getWriter().printf("<li>" + products.get(i - 1).toString() + "</li>");
        }
        resp.getWriter().printf("</ol></body></html>");
        resp.getWriter().close();

    }

}
