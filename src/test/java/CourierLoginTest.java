import body.Courier;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourierLoginTest {

    private Courier courier;
    CourierSteps courierSteps = new CourierSteps();
    GenerateTestData random = new GenerateTestData();

    @Before
    public void setUp() {
        courier = new Courier(random.generateString(), random.generateString(), random.generateString());
        courierSteps.createCourierSuccessfully(courier);
    }

    @After
    public void endTest() {
            courierSteps.deleteCourier(courier);
    }

    @Test
    @DisplayName("Курьер может быть успешно авторизован")
    public void courierCanLogInSuccessfully(){
        courierSteps.courierLoginReturnId(courier);
    }

    @Test
    @DisplayName("Курьер не может авторизован, если поле Пароль пустое")
    public void courierCanNotLogInWhenFieldIsMissing(){
        courier.setPassword("");
        courierSteps.courierLoginWithMissingField(courier);
    }

    @Test
    @DisplayName("Курьер не может авторизован, если Пароль указан неверно")
    public void courierCanNotLogInWhenPasswordIsIncorrect(){
        courier.setPassword(courier.getPassword() + "1");
    }

    @Test
    @DisplayName("Курьер не может быть авторизован, если Логин указан неверно")
    public void courierCanNotLoginWhenLoginIsIncorrect(){
        courier.setLogin(courier.getLogin() + "1");
    }
}
