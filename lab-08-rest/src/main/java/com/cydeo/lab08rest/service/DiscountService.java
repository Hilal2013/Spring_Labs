package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> findAllDiscount();
    DiscountDTO findFirstDiscountByName(String name);
DiscountDTO save(DiscountDTO discountDTO);
DiscountDTO update(DiscountDTO discountDTO);
}
