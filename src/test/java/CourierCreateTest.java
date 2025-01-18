import body.Courier;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourierCreateTest {

    private Courier courier;
    CourierSteps courierSteps = new CourierSteps();
    GenerateTestData random = new GenerateTestData();

    @Before
    public void setUp() {
        courier = new Courier(random.generateString(), random.generateString(), random.generateString());
        courierSteps.courierLoginReturnId(courier);
    }

    @After
    public void endTest() {
        courierSteps.deleteCourier(courier);
    }

    @Test
    @DisplayName("Курьер может быть успешно создан")
    public void courierCanBeCreated() {
        courierSteps.createCourierSuccessfully(courier);
    }

    @Test
    @DisplayName("Курьер не может быть создан, если поле Пароль пустое")
    public void courierWithMissingPasswordCanNotBeCreated() {
        courier.setPassword("");
        courierSteps.createCourierWithMissingData(courier);
    }

    @Test
    @DisplayName("Курьер не может быть создан, если поле Логин пустое")
    public void courierWithMissingLoginCanNotBeCreated() {
        courier.setLogin("");
        courierSteps.createCourierWithMissingData(courier);
    }

    @Test
    @DisplayName("Курьер не может быть создан, если такой курьер уже есть в системе")
    public void courierWithExistingDataCanNotBeCreated() {
        courierSteps.createCourierWithDuplicateData(courier);
    }

}
