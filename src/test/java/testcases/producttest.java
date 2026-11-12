package testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.payload;
import pojo.products;
import routes.Routes;

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class producttest extends baseclass
{
    static int id=0;

   @Test
    public void productTest()
    {
        given()
                .when().get(Routes.Get_all_products)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0))
                .log().all();

    }

   @Test
    void getsingleproduct(){
       int productid = configReader.getIntProperty("productid");
        given()
                .pathParam("id",productid)
                .when()
                .get(Routes.Get_product_by_id)
                .then()
                .statusCode(200)
                .log().body();
    }
   // @Test
    void getlimitproduct(){

      Response resp= given()
                .queryParam("limit",5)
                .when()
                .get(Routes.Get_product_by_limit)
                .then()
                .statusCode(200)
                .log().body()
              .extract().response();
        List<Integer> productid = resp.jsonPath().getList("id",Integer.class);
       assertThat( issortindescending(productid),is(true));


    }
    @Test
    void getproductcategory(){
       given()

               .when()
               .get(Routes.get_all_category)
               .then()
               .statusCode(200)
               .log().body();
    }
    @Test
    void getproduct_by_category(){
       String category[]={"electronics","furniture","clothing","books"};
       Random random=new Random();


       String selectedCategory =category[random.nextInt(category.length)];
        given()
                .pathParam("category",selectedCategory )
                .when()
                .get(Routes.get_prodiuct_by_category)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    void createproduct(){
       products newproduct =payload.productpayload();

       id = given()
              .contentType(ContentType.JSON)
              .body(newproduct)
               .when()
              .post(Routes.create_product)
               .then()
               .statusCode(201)
              .body("title",equalTo(newproduct.getTitle()))
              .extract().jsonPath().getInt("id");
        System.out.println("product id : "+id);

    }
    @Test
    void updateproduct(){
products updatedproduct =payload.productpayload();

       given()
               .pathParam("id",id)
               .contentType(ContentType.JSON)
               .body(updatedproduct)
               .when()
               .put(Routes.update_product)
               .then()
               .statusCode(200)
               .log().all();

    }

    @Test
    void deleteproduct(){

       given()
               .pathParam("id",id)
               .when()
               .delete(Routes.delete_product)
               .then()
               .statusCode(200);
    }

}
