package quick.brick;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private final int id;
    private final String title;
    private final BigDecimal cost;

    public Product(int id, String title, BigDecimal cost) {

        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {

        return "id: " + id + "; Название: " + title +
                "; Цена: " + cost.setScale(0, RoundingMode.CEILING) + "р;";
    }
}
