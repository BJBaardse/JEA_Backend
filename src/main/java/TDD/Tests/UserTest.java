package TDD.Tests;

import TDD.models.User;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;


public class UserTest {



    @Rule
    public WireMockRule wiremockRule = new WireMockRule(8888);

    @Test
    public void CreateUser() {
        User firstuser = new User("new user", "newUserPasswd");

        WireMock wiremock = new WireMock(8888);


        wiremock.register(put(urlEqualTo("/testing/createuser"))
                .withHeader("Content-Type", containing("json"))
                .withRequestBody(containing("new user"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("")));

        given()
                .port(8888)
                .contentType("application/json")
                .body(firstuser)
                .when().put("/testing/createuser").then()
                .statusCode(200);
        wiremock.verifyThat(WireMock.putRequestedFor(urlEqualTo("/testing/createuser")));


    }

}