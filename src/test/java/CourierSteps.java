import body.Courier;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import response.CourierLoginResponse;
import request.CourierApi;
import response.CourierCreateResponse;
import response.CourierDeleteResponse;

import static org.junit.Assert.assertEquals;

public class CourierSteps {

    private CourierApi courierApi = new CourierApi();

    private Courier courier;

    private CourierCreateResponse expectedCreateResponse;
    private CourierCreateResponse actualCreateResponse;
    private CourierLoginResponse expectedLoginResponse;
    private CourierLoginResponse actualLoginResponse;
    private CourierDeleteResponse actualDeleteResponse;

    @Step
    public void createCourierSuccessfully(Courier model) {
        expectedCreateResponse = new CourierCreateResponse(true);
        actualCreateResponse = courierApi.createCourier(model);
        assertEquals(expectedCreateResponse.getOk(), actualCreateResponse.getOk());
    }

    @Step
    public void createCourierWithMissingData(Courier model) {
        expectedCreateResponse = new CourierCreateResponse(400, "Недостаточно данных для создания учетной записи");
        actualCreateResponse = courierApi.createCourier(model);
        assertEquals(expectedCreateResponse.getCode(), actualCreateResponse.getCode());
        assertEquals(expectedCreateResponse.getMessage(), actualCreateResponse.getMessage());
    }

    @Step
    public void createCourierWithDuplicateData(Courier model) {
        expectedCreateResponse = new CourierCreateResponse(409, "Этот логин уже используется. Попробуйте другой.");
        courierApi.createCourier(model);
        actualCreateResponse = courierApi.createCourier(model);
        assertEquals(expectedCreateResponse.getCode(), actualCreateResponse.getCode());
        assertEquals(expectedCreateResponse.getMessage(), actualCreateResponse.getMessage());
    }

    @Step
    public Integer courierLoginReturnId(Courier courier) {
        actualLoginResponse = courierApi.courierLogin(courier);
        Integer courierId = actualLoginResponse.getId();
        if (courierId != null) {
            courier.setId(courierId);
        }
        return courierId;
    }

    @Step
    public void courierLoginWithMissingField(Courier courier){
        actualLoginResponse = courierApi.courierLogin(courier);
        expectedLoginResponse = new CourierLoginResponse(400, "Недостаточно данных для входа");
        assertEquals(expectedLoginResponse.getCode(), actualLoginResponse.getCode());
        assertEquals(expectedLoginResponse.getMessage(), actualLoginResponse.getMessage());
    }

    @Step
    public void courierLoginWithTheIncorrectData(String login, String password) {
        courier = new Courier(login, password);
        actualLoginResponse = courierApi.courierLogin(courier);
        expectedLoginResponse = new CourierLoginResponse(404, "Учетная запись не найдена");
        assertEquals(expectedLoginResponse.getCode(), actualLoginResponse.getCode());
        assertEquals(expectedLoginResponse.getMessage(), actualLoginResponse.getMessage());
    }

    @Step
    public Response deleteCourier(Courier courier) {
        Response response = null;
        if (courier.getLogin() != null && courier.getPassword() != null) {
            response = courierApi.deleteCourier(courier.getId());
        }
        return response;
    }
}

