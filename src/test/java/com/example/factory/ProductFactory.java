import com.github.javafaker.Faker;
import com.example.model.Product;

public class ProductFactory {

    private static final Faker faker = new Faker();

    public static Product createProduct() {
        return new Product(
                faker.commerce().productName(),
                faker.commerce().department(),
                faker.bool().bool(),
                Double.parseDouble(faker.commerce().price().replaceAll("[^\\d.]", ""))
        );
    }
}
