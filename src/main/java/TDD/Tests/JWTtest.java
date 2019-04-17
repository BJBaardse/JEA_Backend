package TDD.Tests;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import jwt.AuthenticationEndpoint;
import model.User;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.given;

public class JWTtest {

    @Rule
    public WireMockRule wiremockRule = new WireMockRule(8888);

    @Test
    public void issueToken() {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
//        try {
//            Algorithm algorithm = Algorithm.HMAC256("tokentest");
//            String token = JWT.create()
//                    .withIssuer("test")
//                    .withClaim("username",user.getUserName())
//                    .withClaim("ID",user.getGebruikersiD())
//                    .withClaim("Roles" , String.valueOf(user.getRole()))
//                    .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 1000)))
//                    .sign(algorithm);
//            return token;
//
//
//        }catch (Exception e){
//            return "";
//        }
//        User firstuser = new User("admin", "admin");
//        AuthenticationEndpoint authenticationEndpoint = new AuthenticationEndpoint();
//
//        WireMock wiremock = new WireMock(8888);
//
//
//        wiremock.register(put(urlEqualTo("/testing/createtoken"))
//                .withHeader("Content-Type", containing("json"))
//                .withRequestBody(containing("jwtToken"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withBody("")));
//
//        given()
//                .port(8888)
//                .contentType("application/json")
//                .body(firstuser)
//                .when().put("/testing/createtoken").then()
//                .statusCode(200);
//        wiremock.verifyThat(WireMock.putRequestedFor(urlEqualTo("/testing/createtoken")));
    }
}
