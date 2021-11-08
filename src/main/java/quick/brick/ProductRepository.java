package quick.brick;

import org.springframework.stereotype.Component;

@Component
public interface ProductRepository {

    Product findById(Long id);
    int getProductsSize();

}
