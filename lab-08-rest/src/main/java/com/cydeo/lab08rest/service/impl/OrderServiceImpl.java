package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<OrderDTO> findAllOrder() {
        return orderRepository.findAll().stream()
                .map(entity->mapperUtil.convert(entity,new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findAllByCustomerEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email).stream()
                .map(entity->mapperUtil.convert(entity,new OrderDTO()))
                .collect(Collectors.toList());
    }


    @Override
    public List<OrderDTO> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod) {
       return orderRepository.findAllByPayment_PaymentMethod(paymentMethod).stream()
                .map(entity->mapperUtil.convert(entity,new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
   orderRepository.save( mapperUtil.convert(orderDTO,new Order()));

        return orderDTO;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order order = orderRepository.save(mapperUtil.convert(orderDTO, new Order()));
        return mapperUtil.convert(order,new OrderDTO());

//        Order order = mapperUtil.convert(orderDTO, new Order());
//        orderRepository.findById(order.getId()).ifPresent(renewOrder -> {
//           renewOrder.setId(order.getId());
//            renewOrder.setPaidPrice(order.getPaidPrice());
//            renewOrder.setTotalPrice(order.getTotalPrice());
//            renewOrder.setCustomer(order.getCustomer());
//            renewOrder.setCart(order.getCart());
//            renewOrder.setPayment(order.getPayment());
//            orderRepository.save(renewOrder);
//        });


    }
}
