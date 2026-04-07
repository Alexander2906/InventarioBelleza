package pe.edu.unu.inventariobellezaappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

