package request;

import body.OrderCreateModel;
import body.OrdersModel;
import response.OrderCancelResponse;
import response.OrderCreateResponse;

import java.util.HashMap;
import java.util.Map;

public class OrdersApi extends BaseHttpClient {

    private final String apiBasePath = "/api/v1/orders";
    private final String apiCancelPath = "/api/v1/orders/cancel?track=";

    public OrderCreateResponse orderCreate(OrderCreateModel orderCreateModel) {
        return doPostRequest(apiBasePath, orderCreateModel).as(OrderCreateResponse.class);
    }

    public OrdersModel ordersGet() {
        return doGetRequest(apiBasePath).as(OrdersModel.class);
    }

    public OrderCancelResponse orderCancel(Integer value) {
        Map<String, Integer> params = new HashMap<>();
        params.put("track", value);
        String cancelPath = apiCancelPath + value;
        return doPutRequest(cancelPath, params).as(OrderCancelResponse.class);
    }
}
