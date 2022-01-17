package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
    Order save(Order order);
}
