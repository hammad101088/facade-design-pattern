package facade;

import com.shaft.api.RestActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import objectModel.CheckoutObjectModel;
import org.testng.annotations.Test;

public class CheckoutFacade {

    //****** variables ******//
    int cart_id;
    CheckoutObjectModel checkoutObjectModel;

    //****** methods &keywords ******//
    /**
     * 1st business action - add product to cart.
     * consists of 3 API requests:
     * - create cart request
     * - get products request
     * - add product to cart request
     */
    public CheckoutFacade addProductToCart() {
        //(1st business action - add product to cart)
        int cart_id = checkoutObjectModel.createCart();
        int product_id = checkoutObjectModel.getProducts();
        checkoutObjectModel.addProductToCart(cart_id, product_id);
        return new CheckoutFacade();
    }

    /**
     * 2nd business action - add shipping details.
     * consists of 4 API requests:
     * - get regions request
     * - get cities request
     * - create customer address request
     * - set billing address on cart request
     */
    public CheckoutFacade addShippingDetails(String streetName) {
        int region_id = checkoutObjectModel.getRegions();
        int city_id = checkoutObjectModel.getCities(region_id);
        int address_id = checkoutObjectModel.createCustomerAddress(city_id, streetName);
        checkoutObjectModel.setBillingAddressOnCart(cart_id, address_id);
        return new CheckoutFacade();
    }

    /**
     * 3rd business action - add payment details.
     * consists of 2 API requests:
     * - set shipping method on cart
     * - set payment method
     */
    public CheckoutFacade addPaymentDetails(String shippingMethod, String paymentMethod) {
        checkoutObjectModel.setShippingMethodOnCart(cart_id, shippingMethod);
        checkoutObjectModel.setPaymentMethod(cart_id, paymentMethod);
        return new CheckoutFacade();
    }

    /**
     * 4th business action - place order.
     * consists of 1 API request:
     * - place order
     */
    public Response placeOrder() {
        return checkoutObjectModel.placeOrder(cart_id);
    }

}
