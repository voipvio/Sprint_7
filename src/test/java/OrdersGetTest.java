import body.OrdersModel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import request.OrdersApi;

import static org.junit.Assert.*;

public class OrdersGetTest {

    OrdersApi ordersApi = new OrdersApi();

    @Test
    @DisplayName("Список заказов может быть успешно получен")
    public void listOfOrdersCanBeReceived(){
        OrdersModel orders = ordersApi.ordersGet();
        assertNotNull(orders.getOrders());
        assertNotNull(orders.getOrders().getId());
    }
}
