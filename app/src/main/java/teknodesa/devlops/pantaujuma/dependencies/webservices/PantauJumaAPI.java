package teknodesa.devlops.pantaujuma.dependencies.webservices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Marthin on 2/21/2018.
 */

public interface PantauJumaAPI {
    /*
    @POST("user/register")
    Call<ResponseRegister> registerUser(@Header("Authorization") String token, @Body RegisterModel registerModel);

    @POST("user/login")
    Call<ResponseLogin> loginUser(@Header("Authorization") String token, @Body LoginModel loginModel);

    @POST("user/updateUser")
    Call<ResponseLogin> updateUser(@Header("Authorization") String token, @Body UpdateUserModel updateUserModel);

    @GET("promo/getPromotion")
    Call<ResponsePromo> getPromotion(@Header("Authorization") String token);

    @POST("vendor/getAllData")
    Call<ResponseAllData> getAllData(@Header("Authorization") String token,@Body UserLocation userLocation);

    @POST("vendor/getTime")
    Call<ResponseGetTime> getTimeDelivery(@Header("Authorization") String token, @Body UserLocation userLocation);

    @GET("product/getProduct/{idVendor}/{idUser}")
    Call<ResponseProduct> getAllProduct(@Header("Authorization") String token, @Path("idVendor") int idVendor, @Path("idUser") String idUser);

    @POST("order/insertOrder")
    Call<ResponseInsertBooking> insertBooking(@Header("Authorization") String token, @Body BookingModel bookingModel);

    @POST("onanprint/insertPrint")
    Call<ResponseInsertPrint> insertPrint(@Header("Authorization") String token, @Body PrintModel printModel);

    @POST("order/insertItem")
    Call<ResponseInsertItemBooking> insertItemBooking(@Header("Authorization") String token, @Body ItemModel itemModel);

    @GET("order/deleteBooking/{bookingCode}")
    Call<ResponseDelete> deleteBooking(@Header("Authorization") String token, @Path("bookingCode") String bookingCode);

    @GET("payment/getPotonganOnan/{price}")
    Call<ResponseGetPotongan> getPotongan(@Header("Authorization") String token, @Path("price") int price);

    @GET("payment/getPaymentMethod")
    Call<ResponsePaymentMethod> getPaymentMethod(@Header("Authorization") String token);

    @GET("payment/getTotalPrice/{bookingCode}")
    Call<ResponseGetPrice> getPrice(@Header("Authorization") String token, @Path("bookingCode") String bookingCode);

    @GET("payment/getPriceTemp/{dataBooking}")
    Call<ResponsePriceNonBooking> getPriceTemp(@Header("Authorization") String token, @Path("dataBooking") String dataBooking);

    @GET("product/getDataBooking/{bookingCode}")
    Call<ResponseDataBooking> getDataBooking(@Header("Authorization") String token, @Path("bookingCode") String bookingCode);

    @GET("product/getAllBooking/{idUser}")
    Call<ResponseAllBooking> getAllBooking(@Header("Authorization") String token, @Path("idUser") String idUser);

    @POST("pulsa/insertPulsa")
    Call<ResponseInsertPulsa> insertPulsa(@Header("Authorization") String token, @Body PulsaModel pulsaModel);

    @GET("pulsa/getDataPulsa")
    Call<ResponseDataPulsa> getDataPulsa(@Header("Authorization") String token);

    @GET("pulsa/getAllBooking/{idUser}")
    Call<ResponseAllBookingPulsa> getAllBookingPulsa(@Header("Authorization") String token,@Path("idUser") String idUser);

    @GET("food/getProductUserLove/{idUser}")
    Call<ResponseUserLoveFood> getLoveFoodUser(@Header("Authorization") String token,@Path("idUser") String idUser);

    @GET("food/HotThisWeek")
    Call<ResponseHotAndNew> getHotThisWeek(@Header("Authorization") String token);

    @GET("food/NewThisWeek")
    Call<ResponseHotAndNew> getNewThisWeek(@Header("Authorization") String token);

    @POST("food/dislikeFood")
    Call<ResponseFoodUserLove> dislikeFood(@Header("Authorization") String token, @Body FoodUserLoveBody foodUserLoveBody);

    @POST("food/likeFood")
    Call<ResponseFoodUserLove> likeFood(@Header("Authorization") String token, @Body FoodUserLoveBody foodUserLoveBody);

    @POST("payment/insertTransaction")
    Call<ResponseInsertTransactionFood> insertTransactionFood(@Header("Authorization") String token, @Body BodyPayment bodyPayment);

    @POST("onanprint/checkPrice")
    Call<ResponseCheckPricePrint> checkPricePrint(@Header("Authorization") String token, @Body BodyCheckPricePrint bodyCheckPricePrint);

    @GET("onanprint/getAllBooking/{idUser}")
    Call<ResponseAllBookingPrint> getAllBookingPrint(@Header("Authorization") String token, @Path("idUser") String idUser);

    @GET("onanpay/getSaldo/{idUser}")
    Call<ResponseGetSaldo> getSaldo(@Header("Authorization") String token, @Path("idUser") String idUser);

    @GET("onanpoint/getPoint/{idUser}")
    Call<ResponseGetPoint> getPoint(@Header("Authorization") String token, @Path("idUser") String idUser);

    @GET("onanpay/getHistoryTransaction/{idUser}")
    Call<ResponseHistoryOnanPay> getHistoryOnanPay(@Header("Authorization") String token, @Path("idUser") String idUser);

    @GET("onannews/getAllNews")
    Call<ResponseNewsLetter> getAllNewsLetter(@Header("Authorization") String token);
*/
}
