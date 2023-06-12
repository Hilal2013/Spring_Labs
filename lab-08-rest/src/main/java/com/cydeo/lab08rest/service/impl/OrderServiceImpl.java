package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.UpdateOrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.exception.NotFoundException;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.CartService;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.OrderService;
import com.cydeo.lab08rest.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CustomerService customerService, PaymentService paymentService, CartService cartService) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
    }


    @Override
    public List<OrderDTO> findAllOrder() {
        return orderRepository.findAll().stream()
                .map(entity -> mapperUtil.convert(entity, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findAllByCustomerEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email).stream()
                .map(entity -> mapperUtil.convert(entity, new OrderDTO()))
                .collect(Collectors.toList());
    }


    @Override
    public List<OrderDTO> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod) {
        return orderRepository.findAllByPayment_PaymentMethod(paymentMethod).stream()
                .map(entity -> mapperUtil.convert(entity, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        orderRepository.save(mapperUtil.convert(orderDTO, new Order()));

        return orderDTO;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {

//look for the order
        orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new RuntimeException("Order could not be found"));
        validateRelatedFieldsAreExist(orderDTO);
//if  it has dependencies like customer cart payment
//if fields are exist
        Order updatedOrder = orderRepository.save(mapperUtil.convert(orderDTO, new Order()));

        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }

    public OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order could not be found."));
        //if we are getting the same value, it is not necessary to update the actual value

        boolean changeDetected = false;

        if (!order.getPaidPrice().equals(updateOrderDTO.getPaidPrice())) {
            order.setPaidPrice(updateOrderDTO.getPaidPrice());
            changeDetected = true;
        }

        if (!order.getTotalPrice().equals(updateOrderDTO.getTotalPrice())) {
            order.setTotalPrice(updateOrderDTO.getTotalPrice());
            changeDetected = true;
        }

        //if there is any change, update the order and return it
        if (changeDetected) {
            Order updateOrder = orderRepository.save(order);
            return mapperUtil.convert(updateOrder, new OrderDTO());
        } else {
            throw new RuntimeException("No changes detected");
        }

    }

    private void validateRelatedFieldsAreExist(OrderDTO orderDTO) {
        if (!customerService.existById(orderDTO.getCustomerId())) {
            throw new NotFoundException("Customer could not found!");
        }
        if (!paymentService.existById(orderDTO.getPaymentId())) {
            throw new NotFoundException("Payment could not found!");
        }
        if (!cartService.existById(orderDTO.getCartId())) {
            throw new NotFoundException("Cart could not found!");
        }

    }

}
