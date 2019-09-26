package de.hilling.junit.cdi.microprofile;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ControllerTestIT {


    @Test
    void assertStringProperty() {
        given()
                .when().get("/app/propertyString")
                .then()
                .statusCode(200)
                .body(is("Runtime Defaults Demo"));
    }

    @Test
    void assertIntegerProperty() {
        given()
                .when().get("/app/propertyInteger")
                .then()
                .statusCode(200)
                .body(is("815"));
    }

    @Test
    void assertLongProperty() {
        given()
                .when().get("/app/propertyLong")
                .then()
                .statusCode(200)
                .body(is("81508150815081"));
    }

    @Test
    void assertBooleanProperty() {
        given()
                .when().get("/app/propertyBoolean")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @Test
    void assertHorseProperty() {
        given()
                .when().get("/app/propertyHorse")
                .then()
                .statusCode(200)
                .body(is("Rih"));
    }
}
