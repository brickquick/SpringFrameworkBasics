package quick.brick;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemProductRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", BigDecimal.valueOf(Math.random() * 100)),
                new Product(2L, "Milk", BigDecimal.valueOf(Math.random() * 100)),
                new Product(3L, "Apples", BigDecimal.valueOf(Math.random() * 100)),
                new Product(4L, "Bananas", BigDecimal.valueOf(Math.random() * 100)),
                new Product(5L, "Oranges", BigDecimal.valueOf(Math.random() * 100))
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public int getProductsSize() {
        return products.size();
    }

}
