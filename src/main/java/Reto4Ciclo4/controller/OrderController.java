package Reto4Ciclo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Reto4Ciclo4.model.Order;
import Reto4Ciclo4.service.OrderService;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/order"))
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {
    @Autowired
    private OrderService orderService;

      @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return orderService.delete(id);
    }
    //Ordenes por zona
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }

    //Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order>getBySalesManId(@PathVariable("id") Integer id){
          return orderService.getBySalesManId(id);
    }

    //Ordenes de un asesor x Estado
    @GetMapping("/state/{status}/{id}")
    public List<Order>getBySalesManIdAndStatus(@PathVariable("id")Integer id, @PathVariable("status")String status){
          return orderService.getBySalesManIdAndStatus(id, status);
    }

    //Ordenes de un asesor x fecha
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order>getByRegisterDayAndSalesManId(@PathVariable("registerDay")String registerDay, @PathVariable("id") Integer id){
          return orderService.getByRegisterAndSalesManId(registerDay, id);
    }




}
