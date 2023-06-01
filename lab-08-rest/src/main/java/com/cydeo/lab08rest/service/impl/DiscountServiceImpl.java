package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<DiscountDTO> findAllDiscount() {
        return discountRepository.findAll().stream()
                .map(entity -> mapperUtil.convert(entity, new DiscountDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountDTO> findAllDiscountByName(String name) {
        return discountRepository.findAllByName(name).stream()
                .map(entity -> mapperUtil.convert(entity, new DiscountDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO save(DiscountDTO discountDTO) {
        discountRepository.save(mapperUtil.convert(discountDTO,new Discount()));
        return discountDTO ;
    }

    @Override
    public void update(DiscountDTO discountDTO) {
        Discount discount = mapperUtil.convert(discountDTO, new Discount());
        discountRepository.findById(discount.getId())
                .ifPresent(renewDiscount->{renewDiscount.setName(discount.getName());
                    renewDiscount.setDiscountType(discount.getDiscountType());
                    renewDiscount.setDiscount(discount.getDiscount());
                    discountRepository.save(renewDiscount);
                });
    }
}
