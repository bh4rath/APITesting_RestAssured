package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jvnet.staxex.BinaryText;
import payloads.Booking;

import static io.restassured.RestAssured.given;

public class BookingApi extends BaseApi {
    private static final String apiUrl = baseUrl + "booking/";

    public static Response getBookings() {
        return given().get(apiUrl);
    }

    public static Response getBooking(int id, String mediaType){
        return given()
                .header("Accept", mediaType)
                .get(apiUrl + Integer.toString(id));
    }

    public static Response postBooking(Booking payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl);
    }


}
