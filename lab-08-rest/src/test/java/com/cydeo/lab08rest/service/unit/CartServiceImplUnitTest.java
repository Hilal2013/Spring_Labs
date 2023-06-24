package com.cydeo.lab08rest.service.unit;

import com.cydeo.lab08rest.entity.*;
import com.cydeo.lab08rest.enums.CartState;
import com.cydeo.lab08rest.enums.DiscountType;
import com.cydeo.lab08rest.repository.CartItemRepository;
import com.cydeo.lab08rest.repository.CartRepository;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.impl.CartServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplUnitTest {
    @Mock
    private ProductRepository productRepository;
    //not do anything except you say
    @Mock
    private CartRepository cartRepository;
    @Mock
    private CartItemRepository cartItemRepository;
    @Mock
    private DiscountRepository discountRepository;
    //to be able to initiliaze this class//we need to inject mocks inside this class
    @InjectMocks
    private CartServiceImpl cartService;
//addToCart method first line find product if not throw
    @Test
    public void should_not_add_to_cart_when_product_doesnt_exist(){
when(productRepository.findById(1L)).thenReturn(Optional.empty());
//findById is returning optional value //if returns empty =>im expecting runtimeexception
        //catchThrowable is static method=> inside lambda
        Throwable throwable = catchThrowable(() ->
                cartService.addToCart(new Customer(), 1L, 10));
        assertThat(throwable).isInstanceOf(RuntimeException.class);


    }
    //addToCart method second line
    @Test
    public void should_throw_exception_when_product_remaining_quantity_is_less_than_quantity(){
        Product product = new Product();
        product.setRemainingQuantity(10);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Throwable throwable = catchThrowable(() ->
                cartService.addToCart(new Customer(), 1L, 15));
        assertThat(throwable).isInstanceOf(RuntimeException.class);

        //assertEquals("Not enough stock",throwable);??
        assertThat(throwable).hasMessage("Not enough stock");
    }
    //addToCart method third line

    @Test
    public void should_add_item_to_cart_when_cart_exists_and_cart_item_exists_in_the_cart(){
        // Given
        //i need product,cart, cartitem
        Product product = new Product();
        product.setId(1L);//for product repository
        product.setRemainingQuantity(10);

        Cart cart = new Cart();
        cart.setCartState(CartState.CREATED);
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(2);

        Customer customer = new Customer();
        customer.setId(1L);

        // When
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(cartRepository.findAllByCustomerIdAndCartState
                (customer.getId(), CartState.CREATED)).thenReturn(cartList);
        when(cartItemRepository.findAllByCartAndProduct(cart, product)).thenReturn(cartItem);
        // Then
        boolean result = cartService.addToCart(customer, product.getId(), 8);
        assertTrue(result);
        assertThat(cartItem.getQuantity()).isEqualTo(10);
    }
    //addToCart method fourth line and checkCardCount method first line
    // scenario 1 -> cart doesn't exist for customer or cart list is null (new Arraylist or null)

    // scenario 2 -> cart exist but cart item doesn't exist


    //checkCardCount method second line
    @Test
    public void should_throw_an_exception_when_cart_list_size_is_two(){
        Product product = new Product();
        product.setId(1L);
        product.setRemainingQuantity(10);

        Cart cart = new Cart();
        cart.setCartState(CartState.CREATED);

        Cart cart2 = new Cart();//second cart
        cart2.setCartState(CartState.CREATED);

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        cartList.add(cart2);

        Customer customer = new Customer();
        customer.setId(1L);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(cartRepository.findAllByCustomerIdAndCartState
                (customer.getId(), CartState.CREATED)).thenReturn(cartList);

        Throwable throwable = catchThrowable(() ->
                cartService.addToCart(customer, 1L, 8));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

//unit test for applyDiscountTocart method
    @Test
    public void should_throw_exception_when_discount_not_exists(){
        when(discountRepository.findFirstByName("discount")).thenReturn(null);

        Throwable throwable = catchThrowable(() ->
                cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount("discount", new Cart()));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("Discount couldn't find ");
    }
    @Test
    public void should_throw_exception_when_discount_amount_is_null(){

        Discount discount = new Discount();

        when(discountRepository.findFirstByName("discount")).thenReturn(discount);

        Throwable throwable = catchThrowable(() ->
                cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount("discount", new Cart()));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("Discount amount can not be null ");
    }


    // homework
    // discount minimum amount also needs to had a value, otherwise we will throw exception
    // discount minimum amount and discount amount also needs to had a value bigger than ZERO, otherwise we will throw exception


    @Test
    public void should_throw_exception_when_cart_item_list_is_zero(){
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        discount.setMinimumAmount(BigDecimal.valueOf(100));
        discount.setName("discount");
        discount.setDiscountType(DiscountType.AMOUNT_BASED);
        Cart cart = new Cart();//i need to provide same  cart object mock value

        when(discountRepository.findFirstByName(discount.getName())).thenReturn(discount);
        when(cartItemRepository.findAllByCart(cart)).thenReturn(new ArrayList<>());

        Throwable throwable = catchThrowable(() ->
                cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount(discount.getName(), cart));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("There is no item in the cart");
    }


    @Test
    public void should_throw_exception_when_cart_item_list_null(){
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        discount.setMinimumAmount(BigDecimal.valueOf(100));
        discount.setName("discount");
        discount.setDiscountType(DiscountType.AMOUNT_BASED);
        Cart cart = new Cart();

        when(discountRepository.findFirstByName(discount.getName())).thenReturn(discount);
        when(cartItemRepository.findAllByCart(cart)).thenReturn(null);

        Throwable throwable = catchThrowable(() ->
                cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount(discount.getName(), cart));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("There is no item in the cart");
    }
    @Test
    public void should_return_zero_discount_when_total_cart_amount_less_than_minimum_amount(){
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        discount.setMinimumAmount(BigDecimal.valueOf(100));
        discount.setName("discount");
        discount.setDiscountType(DiscountType.AMOUNT_BASED);

        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(5));

        Cart cart = new Cart();

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(6);
//5*6=30 then minimumamount 100
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);

        when(discountRepository.findFirstByName(discount.getName())).thenReturn(discount);
        when(cartItemRepository.findAllByCart(cart)).thenReturn(cartItemList);

        BigDecimal result = cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount(discount.getName(), cart);

        assertThat(result).isEqualTo(BigDecimal.ZERO);//there wont be discount
        assertNull(cart.getDiscount());
    }

    @Test
    public void should_return_discount_amount_when_total_cart_amount_greater_than_minimum_amount_when_discount_type_is_amount_based(){
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        discount.setMinimumAmount(BigDecimal.valueOf(100));
        discount.setName("discount");
        discount.setDiscountType(DiscountType.AMOUNT_BASED);

        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(20));

        Cart cart = new Cart();

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(6);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);

        when(discountRepository.findFirstByName(discount.getName())).thenReturn(discount);
        when(cartItemRepository.findAllByCart(cart)).thenReturn(cartItemList);

        BigDecimal result = cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount(discount.getName(), cart);

        assertThat(result).isEqualTo(BigDecimal.TEN);
        assertNotNull(cart.getDiscount());
    }

    @Test
    public void should_return_discount_amount_when_total_cart_amount_greater_than_minimum_amount_when_discount_type_is_rate_based(){
        Discount discount = new Discount();
        discount.setDiscount(BigDecimal.TEN);
        discount.setMinimumAmount(BigDecimal.valueOf(100));
        discount.setName("discount");
        discount.setDiscountType(DiscountType.RATE_BASED);

        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(20));

        Cart cart = new Cart();

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(6);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);

        when(discountRepository.findFirstByName(discount.getName())).thenReturn(discount);
        when(cartItemRepository.findAllByCart(cart)).thenReturn(cartItemList);

        BigDecimal result = cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount(discount.getName(), cart);

        assertThat(result).isEqualTo(BigDecimal.valueOf(12));
        assertNotNull(cart.getDiscount());
    }

}
