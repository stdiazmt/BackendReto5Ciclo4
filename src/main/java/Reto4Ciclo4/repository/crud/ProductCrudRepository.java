package Reto4Ciclo4.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import Reto4Ciclo4.model.Product;

import java.util.List;

public interface ProductCrudRepository extends MongoRepository<Product, String> {
    public List<Product>findByPrice(double price);

    public List<Product>findByDescriptionContainingIgnoreCase(String description);
}



