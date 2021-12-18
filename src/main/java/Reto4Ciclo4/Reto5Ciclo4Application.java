package Reto4Ciclo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Reto4Ciclo4.repository.crud.OrderCrudRepository;
import Reto4Ciclo4.repository.crud.ProductCrudRepository;
import Reto4Ciclo4.repository.crud.UserCrudRepository;

@SpringBootApplication
public class Reto5Ciclo4Application implements CommandLineRunner {


        @Autowired
        private ProductCrudRepository productRepository;

        @Autowired
        private UserCrudRepository userRepository;

        @Autowired
        private OrderCrudRepository orderRepository;

        public static void main(String[] args) {SpringApplication.run(Reto5Ciclo4Application.class, args);}

    @Override
    public void run(String... args) throws Exception {
     userRepository.deleteAll();
     productRepository.deleteAll();
     orderRepository.deleteAll();

    }
}
