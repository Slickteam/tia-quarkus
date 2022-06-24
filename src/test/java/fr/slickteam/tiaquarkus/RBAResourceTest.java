package fr.slickteam.tiaquarkus;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import fr.slickteam.tiaquarkus.entity.Human;
import fr.slickteam.tiaquarkus.repository.DogRepository;
import fr.slickteam.tiaquarkus.repository.HumanRepository;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.assertj.core.api.Assertions;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
@TestHTTPEndpoint(RBAResource.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RBAResourceTest {

    private final KeycloakTestClient keycloakClient = new KeycloakTestClient();

    private final String rootPath = "http://localhost:8083/access-control";

    @Test
    void freeAccess() {
        RestAssured
                .given()
                .when().get(rootPath)
                .then()
                .statusCode(HttpStatus.SC_OK);

        RestAssured
                .given()
                .auth().oauth2(getAccessToken("alice"))
                .when().get(rootPath)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void userAccess_noAuth() {
        RestAssured
                .given()
                .when().get(rootPath + "/user")
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    void userAccess() {
        RestAssured
                .given()
                .auth().oauth2(getAccessToken("alice"))
                .when().get(rootPath + "/user")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void adminAccess() {
        RestAssured
                .given()
                .auth().oauth2(getAccessToken("alice"))
                .when().get(rootPath + "/admin")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void adminAccess_noAdminRole() {
        RestAssured
                .given()
                .auth().oauth2(getAccessToken("bob"))
                .when().get(rootPath + "/admin")
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }


    private String getAccessToken(String userName) {
        return keycloakClient.getAccessToken(userName);
    }
}