import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class ProductModelTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {
        Product product = new Product("Test Product", "Electronics", true, 100.0);
        productRepository.save(product);
        assertNotNull(product.getId());
    }

    @Test
    void testUpdateProduct() {
        Product product = productRepository.findById(1L).orElseThrow();
        product.setName("Updated Product");
        productRepository.save(product);
        assertEquals("Updated Product", product.getName());
    }

    @Test
    void testDeleteProduct() {
        Product product = productRepository.findById(1L).orElseThrow();
        productRepository.delete(product);
        assertFalse(productRepository.existsById(1L));
    }

    @Test
    void testListAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        assertTrue(products.iterator().hasNext());
    }

    @Test
    void testFindByName() {
        Product product = productRepository.findByName("Test Product");
        assertEquals("Test Product", product.getName());
    }

    @Test
    void testFindByCategory() {
        Product product = productRepository.findByCategory("Electronics");
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void testFindByAvailability() {
        Product product = productRepository.findByAvailability(true);
        assertTrue(product.isAvailability());
    }
}
