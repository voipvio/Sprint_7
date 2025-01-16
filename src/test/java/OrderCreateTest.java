import io.qameta.allure.junit4.DisplayName;
import body.OrderCreateModel;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import request.OrdersApi;
import response.OrderCancelResponse;
import response.OrderCreateResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)

public class OrderCreateTest {

    private OrderCreateModel model;
    private OrderCreateResponse order;
    private OrdersApi ordersHttp = new OrdersApi();

    GenerateTestData random = new GenerateTestData();

    private final String[] color;

    public OrderCreateTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] result() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},
        };
    }

    @Test
    @DisplayName("Создание заказа с разными вариантами цветов")
    public void createOrderWithDifferentColor() {
        model = new OrderCreateModel(random.generateString(), random.generateString()
                , random.generateString()
                , 4
                , "+7 800 355 35 35"
                , 2
                , "2020-06-06"
                , random.generateString()
                , color);
        order = ordersHttp.orderCreate(model);
        Integer track = order.getTrack();
        assertNotNull(track);
        }

    @After
    public void endTest(){
        OrderCancelResponse orderCancelResponse = ordersHttp.orderCancel(order.getTrack());
        assertEquals(true, orderCancelResponse.getOk());
        }
    }