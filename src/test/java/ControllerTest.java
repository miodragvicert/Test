import com.name.no.RunnerApp;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RunnerApp.class)
public class ControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void before() {
        RestAssured.port = port;
    }

    @Test
    public void test() {
        RestAssured
                .get("/test")
                .then()
                .statusCode(201);
    }

}
