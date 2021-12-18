package Reto4Ciclo4.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto4Ciclo4.model.Order;


import java.util.Date;
import java.util.List;


public interface OrderCrudRepository extends MongoRepository<Order, Integer>{


public List<Order> findBySalesManZone(String zone);

public List<Order>findBySalesManId(Integer id);

public List<Order>findBySalesManIdAndStatus(Integer id, String status);

public List<Order>findByRegisterDayAndSalesManId(Date registerDay,Integer id);
}



