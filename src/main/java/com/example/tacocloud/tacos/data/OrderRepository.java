package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.Order;

public interface OrderRepository
{
    Order save(Order order);
}
