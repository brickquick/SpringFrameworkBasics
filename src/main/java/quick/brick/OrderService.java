package quick.brick;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final ProductService productService;
    private Cart cart;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public void userListener(String cmd) {
        String[] parts = cmd.split("\\s");

        if (cmd.equals("create cart")) {
            cart = new Cart(productService);
            System.out.println("Корзина создана");
            return;
        }
        if (cmd.startsWith("add")) {
            String product = parts[1];
            try {
                cart.addToCart(product);
                System.out.println("В корзину добавлен товар:");
                System.out.println(productService.getTitleById(Long.parseLong(product)));
            } catch (Exception e) {
                System.out.println("Такого товара не существует");
            }
            return;
        }
        if (cmd.startsWith("delete")) {
            String product = parts[1];
            if (cart.deleteFromCart(product)) {
                System.out.println("Из карзины удален товар:");
                System.out.println(productService.getTitleById(Long.parseLong(product)));
            } else {
                System.out.println("Товар с таким ID в корзине отсутствует");
            }
            return;
        }
        if (cmd.equals("show cart")) {
            try {
                if (cart.showContent().equals("")) {
                    System.out.println("Корзина пуста");
                    return;
                }
                System.out.println(cart.showContent());
            } catch (NullPointerException e) {
                System.out.println("Корзина не создана");
            }
            return;
        }

        if (cmd.equals("show all")) {
            for (int i = 0; i < productService.getProductSize(); i++) {
                System.out.println(productService.getInfoById((long) i + 1));
            }
            return;
        }
        if (cmd.startsWith("show")) {
            try {
                System.out.println(productService.getInfoById(Long.parseLong(parts[1])));
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }

    }

}