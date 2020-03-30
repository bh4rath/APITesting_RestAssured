import api.BookingApi;
import com.mongodb.ReplicaSetStatus;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Booking;
import payloads.BookingDates;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void getBookingShouldReturn200() {
        Response response = BookingApi.getBookings();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getBookingIdShouldReturn200() {
        Response response = BookingApi.getBooking(1, "application/json");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response body is " + response.getBody());
        System.out.println("Content type is " + response.getContentType());
    }

    @Test
    public void postBookingReturns200() {
        BookingDates dates = new BookingDates.Builder()
                .setCheckin(new Date())
                .setCheckout(new Date())
                .build();

        Booking payload = new Booking.Builder()
                .setFirstname("Bharath")
                .setLastname("Selvam")
                .setTotalprice(200)
                .setBookingdates(dates)
                .setAdditionalneeds("none")
                .build();
        Response response = BookingApi.postBooking(payload);
        System.out.println("the response of post booking is " + response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}