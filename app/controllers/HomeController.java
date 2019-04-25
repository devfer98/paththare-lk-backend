package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.*;
import play.libs.Json;
//import play.libs.Time;
import play.mvc.*;
import dto.RefLinkGenerator;
import java.sql.Time;

import java.util.Date;
import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
//    public Result index() {
//        return ok(views.html.index.render());
//    }
//
//    public Result explore() {
//        return ok(views.html.explore.render());
//    }
//
//    public Result tutorial() {
//        return ok(views.html.tutorial.render());
//    }

    public Result getLink() {
        RefLinkGenerator link= new RefLinkGenerator();
        Date today= new Date();
        Time now = new Time(1,1,1);
        String affiliateLink=link.genLink(today,now,"P1234","S1234","PR234","");
        return ok(Json.toJson(affiliateLink));
    }

    public Result showProduct(String productId){
        Product product=Product.findProduct.byId(productId);
        return ok(Json.toJson(product));
        //return ok(Json.toJson(productId));
    }

    public Result regCustomer(){
        JsonNode body = request().body().asJson();
        String customerId= UUID.randomUUID().toString();
        String fName = body.get("fName").asText();
        String lName = body.get("lName").asText();
        String email=body.get("email").asText();
        String phoneNo=body.get("phoneNo").asText();
        Customer newCustomer=new Customer(customerId,fName,lName,email,phoneNo);
        Ebean.save(newCustomer);
        return ok(Json.toJson("done"));
    }

}
