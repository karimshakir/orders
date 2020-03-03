package com.krew1.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/orders")
public class MainController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrder(@RequestParam String item, @RequestParam Integer amount){
        Order o = new Order();
        o.setItem(item);
        o.setAmount(amount);
        orderRepository.save(o);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Order> getAllOrders(){
        return  orderRepository.findAll();
    }
}
