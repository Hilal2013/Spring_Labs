package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<ResponseWrapper> getOrderList(){
        return ResponseEntity.ok(new ResponseWrapper("OrderList Retrieved", orderService.findAllOrder(), HttpStatus.OK));

    }
    @GetMapping("/email/{email}")
    public  ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable("email") String email){

        return ResponseEntity.ok(new ResponseWrapper("Orders Retrieved", orderService.findAllByCustomerEmail(email), HttpStatus.OK));

    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public  ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable("paymentMethod") PaymentMethod paymentMethod){

        return ResponseEntity.ok(new ResponseWrapper("Orders Retrieved", orderService.findAllByPayment_PaymentMethod(paymentMethod), HttpStatus.OK));

    }

    @PostMapping
    public  ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){

        return ResponseEntity.ok(new ResponseWrapper("Order Saved",  orderService.save(orderDTO), HttpStatus.OK));

    }

    @PutMapping
    public  ResponseEntity<Void> updateOrder(@RequestBody OrderDTO orderDTO)  {
        orderService.update(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
