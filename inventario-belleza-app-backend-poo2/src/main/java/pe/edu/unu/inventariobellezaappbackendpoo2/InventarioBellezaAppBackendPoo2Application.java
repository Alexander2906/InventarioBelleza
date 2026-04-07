package pe.edu.unu.inventariobellezaappbackendpoo2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class InventarioBellezaAppBackendPoo2Application implements CommandLineRunner {

    private final IRepositorioPersona personRepository;
    private final ISupplierRepository supplierRepository;
    private final ICustomerRepository customerRepository;
    private final ICategoryRepository categoryRepository;
    private final IProductRepository productRepository;
    private final IStockMovementRepository stockMovementRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventarioBellezaAppBackendPoo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Limpiar data
        personRepository.deleteAll();
        supplierRepository.deleteAll();
        customerRepository.deleteAll();
        categoryRepository.deleteAll();
        productRepository.deleteAll();
        stockMovementRepository.deleteAll();

        // Seed Personas
        Persona p1 = Persona.builder()
                .nombre("Roberto")
                .apellido("BellezaSupplier")
                .fechaNacimiento(LocalDate.of(1980,4,22))
                .telefono("987654321")
                .build();
        personRepository.save(p1);

        Persona p2 = Persona.builder()
                .nombre("Maria")
                .apellido("Customer")
                .fechaNacimiento(LocalDate.of(1990,5,20))
                .telefono("123456789")
                .build();
        personRepository.save(p2);

        // Suppliers
        Supplier s1 = Supplier.builder()
                .persona(p1)
                .build();
        supplierRepository.save(s1);

        Customer c1 = Customer.builder()
                .persona(p2)
                .build();
        customerRepository.save(c1);

        // Categories
        Category cat1 = Category.builder()
                .name("Maquillaje")
                .build();
        categoryRepository.save(cat1);

        Category cat2 = Category.builder()
                .name("Cuidado Cabello")
                .build();
        categoryRepository.save(cat2);

        // Products
        Product prod1 = Product.builder()
                .name("Labial Rojo")
                .sku("LAB001")
                .price(BigDecimal.valueOf(25.99))
                .stock(100)
                .category(cat1)
                .supplier(s1)
                .build();
        productRepository.save(prod1);

        // Stock Movement
        StockMovement sm1 = StockMovement.builder()
                .type("IN")
                .quantity(50)
                .movDate(LocalDate.now())
                .product(prod1)
                .supplier(s1)
                .build();
        stockMovementRepository.save(sm1);

        System.out.println("Seed data loaded for beauty inventory!");
    }
}


