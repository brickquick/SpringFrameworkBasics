package quick.brick;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final List<Product> productsInCart;
    private final ProductService productService;

    public Cart(ProductService productService) {
        this.productService = productService;
        productsInCart = new ArrayList<>();
    }

    public void addToCart(String cmd) {
        Long id = Long.parseLong(cmd);
        productsInCart.add(productService.getProductById(id));
    }

    public void deleteFromCart(String cmd) {
        Long id = Long.parseLong(cmd);
        productsInCart.remove(productService.getProductById(id));
    }

    public String showContent() {
        StringBuilder content = new StringBuilder();
        int i = 0;
        for (Product product : productsInCart) {
            content.append(++i).append(") ").append(product.toString()).append("\n");
        }
        return content.toString();
    }

}
