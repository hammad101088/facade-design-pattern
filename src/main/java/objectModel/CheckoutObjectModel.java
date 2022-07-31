package objectModel;

import com.shaft.api.RestActions;
import io.restassured.response.Response;

public class CheckoutObjectModel {

    //****** Methods & keywords *****//

        /*
        the following methods should be implemented normally.
        but for the sake of the demo and to save time, I'll be mocking the data.
        please find API implementation examples here: https://github.com/ShaftHQ/SHAFT_ENGINE/blob/master/src/test/java/testPackage01/SHAFTWizard/Test_Wizard_API.java
        */

    /**
     * create cart request
     * @return cart id to be used while performing different operations on cart
     */
    public int createCart() {
        return 1;
            }

    /**
     * "get all products" request to get any "product ID" from the list
     * @return product id
     */
    public int getProducts() {
        return 1;
    }

    /**
     * add product to card request
     * @param product_id
     * @param cart_id
     * @return
     */
    public Response addProductToCart(int cart_id, int product_id) {
        return null;
    }

    /**
     * get regions request to get any region id
     * @return region id to be used to get a city id
     */
    public int getRegions() {
        return 1;
    }

    /**
     * get cities request to get any city id
     * @param region_id
     * @return city id to be used to create a new address
     */
    public int getCities(int region_id) {
        return 2;
    }

    /**
     * create customer address request
     * @param city_id
     * @param streetName
     * @return address id to be used in set billing address request
     */
    public int createCustomerAddress(int city_id, String streetName) {
        return 1;
    }

    /**
     * set billing address on cart request
     * @param cart_id
     * @param address_id
     * @return
     */
    public Response setBillingAddressOnCart(int cart_id, int address_id) {
        return null;
    }

    /**
     * set shipping method on cart request
     * @param cart_id
     * @param shippingMethod
     * @return
     */
    public Response setShippingMethodOnCart(int cart_id, String shippingMethod) {
        return null;
    }

    /**
     * set payment method
     * @param cart_id
     * @param paymentMethod
     * @return
     */
    public Response setPaymentMethod(int cart_id, String paymentMethod) {
        return null;
    }

    /**
     * place order request
     * @param cart_id
     * @return order id
     */
    public Response placeOrder(int cart_id) {
        return null;
    }
}
