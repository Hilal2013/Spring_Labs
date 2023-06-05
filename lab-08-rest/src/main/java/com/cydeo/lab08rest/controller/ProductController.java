package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper>  getProductList(){
        return ResponseEntity.ok(new ResponseWrapper("ProductList Retrieved", productService.findAllProduct()));

    }
    @GetMapping("/{name}")
    public  ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name){

        return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", productService.findByName(name)));

    }
    @GetMapping("/top3")
    public  ResponseEntity<ResponseWrapper> getTop3ProductList(){

        return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", productService.findTop3()));

    }
    @GetMapping("/price/{price}")
    public  ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price){

        return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", productService.countProductByPrice(price)));

    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public  ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price,@PathVariable("quantity") Integer quantity){

        return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", productService.findByPriceAndQuantity(price,quantity)));

    }
    @GetMapping("/category/{id}")
    public  ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id){

        return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", productService.findByCategoryId(id)));

    }

    @PostMapping
    public  ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){

        return ResponseEntity.ok(new ResponseWrapper("Product Saved",  productService.save(productDTO)));

    }
    @PostMapping("/categoryandprice")
    public  ResponseEntity<ResponseWrapper> retrieveProductByCategoryAndPrice(@RequestBody ProductRequest productRequest){

        return ResponseEntity.ok(new ResponseWrapper("Product saved",  productService.retrieveAllProductByCategoryAndPrice(productRequest.getCategoryList(),productRequest.getPrice())));

    }
    @PutMapping
    public  ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO)  {
        return ResponseEntity.ok(new ResponseWrapper("Product is successfuly updated",
                productService.update(productDTO)));
    }


}
