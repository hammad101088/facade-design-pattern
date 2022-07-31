import com.shaft.validation.Validations;
import facade.CheckoutFacade;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import objectModel.CheckoutObjectModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFacade {

    CheckoutFacade checkoutFacade;

    @BeforeClass
    public void beforeClass() {
        checkoutFacade = new CheckoutFacade();
    }

    @Test(description = "test checkout scenario using both \"Object Model & Facade\" design patterns")
    @Description("""
            business actions
            1- add product to cart (3 API requests)
            2- add shipping details (4 API requests)
            3- add payment details (2 API requests)
            4- place order (1 API request)
            """)
    public void testFacade() {

        Response placeOrder_response =
                checkoutFacade
                .addProductToCart()
                .addShippingDetails("test street name")
                .addPaymentDetails("test shipping method", "test payment method")
                .placeOrder();
        Validations.assertThat().response(placeOrder_response).extractedJsonValue("data.order_number").isNotNull().perform();
    }
}
