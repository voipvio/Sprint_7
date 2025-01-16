package request;

import body.Courier;
import io.restassured.response.Response;
import response.CourierLoginResponse;
import response.CourierCreateResponse;

public class CourierApi extends BaseHttpClient {

    private final String baseApiPath = "/api/v1/courier/";
    private final String loginApiPath = "/api/v1/courier/login";

    public CourierCreateResponse createCourier(Courier courierCreate) {
        return doPostRequest(baseApiPath, courierCreate).as(CourierCreateResponse.class);
    }

    public Response deleteCourier(Integer courierId) {
        String deletePath = baseApiPath + courierId;
        return doDeleteRequest(deletePath);
    }

    public CourierLoginResponse courierLogin(Courier courier) {
        return doPostRequest(loginApiPath, courier).as(CourierLoginResponse.class);
    }

}
