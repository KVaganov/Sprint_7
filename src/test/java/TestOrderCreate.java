import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrderCreate {
    private Orders orders;
    private OrdersClient orderClient;
    private String[] colors;

    public TestOrderCreate(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {index}")
    public static Object[][] getColors() {
        return new Object[][]{
                {new String[]{"GRAY", "BLACK"}},
                {new String[]{"GRAY"}},
                {new String[]{"BLACK"}},
                {new String[]{}}
        };
    }

    @Test
    @DisplayName("Проверка заказа")
    public void orderCanBeCreated() {
        orders = OrderGeneration.getDefault();
        orderClient = new OrdersClient();
        ValidatableResponse response = orderClient.create(orders);
        int statusCode = response.extract().statusCode();
        assertEquals("Status is incorrect", SC_CREATED, statusCode);
    }
}

