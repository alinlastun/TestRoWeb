package com.lam.testroweb.retrofit

import com.lam.testroweb.model.CreditMovie
import com.lam.testroweb.model.OverviewMovie
import com.lam.testroweb.model.UpcomingModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("movie/upcoming") fun getUpcomingMovies(@Query("api_key") apiKey:String, @Query("page")page:String): Observable<UpcomingModel>
    @GET("movie/{movie_id}") fun getOverview(@Path("movie_id") movieId:String, @Query("api_key") apiKey:String): Observable<OverviewMovie>
    @GET("movie/{movie_id}/credits") fun getCredits(@Path("movie_id") movieId:String, @Query("api_key") apiKey:String): Observable<CreditMovie>

}


  /*  @GET("/api/info/not_logged") fun getAllDataLogOutSingle(): Single<AllDataLogOut>

    //Check Internet Connection
    @GET("/imghp") fun checkInternet(): Call<Void>

    @GET("/api/platform/cities") fun getAllCities(): Observable<MutableList<CityModelDB>>
    @GET("/api/platform/cities") fun getAllCities2(): Call<MutableList<CityModelDB>>

    @GET("api/orders/calendar_intervals") fun getAllHours(): Observable<MutableList<String>>
    @GET("api/orders/calendar_intervals") fun getAllHours2(): Call<MutableList<String>>
*//*    @GET("/api/platform/categories") fun getAllCategories(): Observable<MutableList<Platform>>*//*


    //LogIn
    @POST("/api/login") fun userLogin(@Body nRegister: LoginModel): Observable<UserInfoModelDB>
    @GET("/api/users/{user_id}/logout") fun userLogout(@Path("user_id") userId:String): Observable<LoginModel>
    @POST("/api/reset-password") fun resetPassword(@Body nRegister: LoginModel): Observable<LoginModel>
    @POST("/api/register") fun userRegister(@Body nRegister: RegisterModel): Observable<UserInfoModelDB>

    // Main Screen
    @GET("/api/products") fun getListOfProducts(): Observable<List<ProductsModelDB>>
    @GET("/api/products") fun getListOfProducts2(): Call<MutableList<ProductsModelDB>>

    //Payment Method
    @GET("/api/payment_method") fun getInfoPayment(): Observable<List<PaymentDB>>
    @GET("/api/payment_method") fun getInfoPayment2(): Call<List<PaymentDB>>
    //Contact Us
    @GET("/api/contact") fun getInfo(): Observable<List<ContactModel>>
    @GET("/api/contact") fun getInfo2(): Call<MutableList<ContactModel>>
    //Info App
    @GET("/api/about") fun getInfoApp(): Observable<List<InfoAppModelDB>>
    @GET("/api/about/mobile") fun getInfoApp2(): Call<List<InfoAppModelDB>>
    //@Body mobileFlag: MobileFlag
    // Review
    @GET("/api/{product_id}/reviews") fun getListOfReviews(@Path("product_id") productId:String): Observable<ReviewModel>
    @POST("/api/users/{user_id}/orders/{orders_id}/add_review") fun addReview(@Path("user_id") userId:String,@Path("orders_id") orderId:String,@Body review: SendReviewModel): Observable<ReviewModel>

    //Delivery Address
    @GET("/api/users/{user_id}/addresses") fun getAllAddresses(@Path("user_id") userId:String): Observable<MutableList<DeliveryAddressModel>>
    @GET("/api/users/{user_id}/addresses") fun getAllAddresses2(@Path("user_id") userId:String): Call<MutableList<DeliveryAddressModel>>
    @POST("/api/users/{user_id}/addresses/{address_id}/default") fun setDefaultAddress(@Path("user_id") userId:String,@Path("address_id") addressId:String): Observable<AddressModel>
    @POST("/api/users/{user_id}/addresses/new") fun addAddress(@Path("user_id") userId:String,@Body addressModel: AddressModel): Observable<AddressModel>
    @POST("/api/users/{user_id}/addresses/{address_id}/update") fun editAddress(@Path("user_id") userId:String,@Path("address_id") addressId:String,@Body addressModel: AddressModel): Observable<AddressModel>
    @POST("/api/users/{user_id}/addresses/{address_id}/delete") fun deleteAddress(@Path("user_id")userId:String,@Path("address_id")addressId:String):Observable<DeliveryAddressModel>


    //History Orders
    @GET("/api/users/{user_id}/orders") fun getListOfHistoryOrder(@Path("user_id") userId:String): Observable<List<HistoryOrderModelDB>>
    @GET("/api/users/{user_id}/orders") fun getListOfHistoryOrder2(@Path("user_id") userId:String): Call<List<HistoryOrderModelDB>>

    //Info Account
    @POST("/api/profil/update/{user_id}") fun updateInfoUser(@Path("user_id") userId:String,@Body userModel: UpdateInfoUserModel): Observable<UserInfoModelDB>
    @GET("/api/users/{user_id}") fun getAllInfoUser(@Path("user_id") userId:String): Observable<UserInfoModelDB>
    @GET("/api/users/{user_id}") fun getAllInfoUser2(@Path("user_id") userId:String): Call<UserInfoModelDB>

    //Calendar
    @GET("/api/getAvailableDays/mobile/{start_date}/{end_date}") fun getAvailableNextDays(@Path("start_date") start_date:String,@Path("end_date") end_date:String): Observable<List<NextDeliveryDates>>



    //Validate Voucher
    @POST("/api/vouchers/validate/{code}") fun validateVoucher(@Path("code") userId:String): Observable<VoucherModel>


    //Place Order
    @POST("/api/users/{user_id}/add_order") fun placeOrder(@Path("user_id") userId:String,@Body userModel: PlaceOrderSend): Observable<PlaceOrderRecive>


    //Validate Voucher
    @POST("/api/orders/validate_products") fun checkProductsPrice(@Body mProducts: VerifyOrder): Observable<VerifyOrder>









    *//*//*/ Main Screen
    @GET("/api/products_ovaz") fun getListOfProducts(): Observable<List<ProductsModelDB>>
*//*
    // Review
    @GET("/api/{product_id}/review") fun getListOfReviws(@Header("x-mock-response-code") mRequestCodeResponse:String,@Path("product_id") productId:String): Observable<ReviewModel>
}*/