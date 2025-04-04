import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertEquals;

public class TestOrderList {

    @Test
    @DisplayName("Получение списка заказов")
    public void listOrders() {
        OrdersClient ordersClient = new OrdersClient();
        ValidatableResponse response = ordersClient.get();
        int statusCode = response.extract().statusCode();
        assertEquals("Статус код не 200", SC_OK, statusCode);
        response.assertThat().body("orders.id", notNullValue());

        // Проверка, что список заказов не пуст
        assertThat(response.extract().body().jsonPath().getList("orders"), is(not(empty())));
    }
}
