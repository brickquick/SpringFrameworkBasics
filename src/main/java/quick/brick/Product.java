package quick.brick;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Product {

    private final Long id;
    private final String title;
    private final BigDecimal cost;

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "id: " + id + "; Название: " + title + "; Цена: " +
                cost.setScale(0, RoundingMode.CEILING) + "$;";
    }

}
