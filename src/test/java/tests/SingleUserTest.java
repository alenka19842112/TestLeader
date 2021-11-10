package tests;

import constans.IConstanceTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.reqres.SingleUser;

import static io.restassured.RestAssured.given;

public class SingleUserTest implements IConstanceTest {
    @Test
    public void getFirstNameSingleUserTest(){
        SingleUser singleUser =
                given().contentType(ContentType.JSON)
                        .log().all()
                .when()
                        .get(USER_URI + "/2")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response().as(SingleUser.class);
        Assert.assertEquals(singleUser.getData().getFirst_name(),"Janet");
    }
}
