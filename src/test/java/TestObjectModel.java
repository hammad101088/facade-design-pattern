import com.shaft.api.RestActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import objectModel.CheckoutObjectModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestObjectModel {

    CheckoutObjectModel checkoutObjectModel;

    @BeforeClass
    public void beforeClass(){
        checkoutObjectModel = new CheckoutObjectModel();
    }

    @Test(description = "test checkout scenario using \"Object Model\" design pattern only")
    @Description("""
    business actions
    1- add product to cart (3 API requests)
    2- add shipping details (4 API requests)
    3- add payment details (2 API requests)
    4- place order (1 API request)
    """)
    public void testObjectModel(){
        //(1st business action - add product to cart)
        int cart_id = checkoutObjectModel.createCart();
        int product_id = checkoutObjectModel.getProducts();
        checkoutObjectModel.addProductToCart(cart_id,product_id);

        //(2nd business action - add shipping details)
        int region_id = checkoutObjectModel.getRegions();
        int city_id = checkoutObjectModel.getCities(region_id);
        int address_id = checkoutObjectModel.createCustomerAddress(city_id,"test street name");
        checkoutObjectModel.setBillingAddressOnCart(cart_id, address_id);

        //(3rd business action - add payment details)
        checkoutObjectModel.setShippingMethodOnCart(cart_id,"test shipping method");
        checkoutObjectModel.setPaymentMethod(cart_id, "test payment method");

        //(4th business action - place order)
        Response placeOrder_response = checkoutObjectModel.placeOrder(cart_id);
        Validations.assertThat().response(placeOrder_response).extractedJsonValue("data.order_number").isNotNull().perform();

    }
}
