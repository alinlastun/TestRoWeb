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
    @GET("movie/{movie_id}") fun getOverview(@Path("movie_id") movieId:Int, @Query("api_key") apiKey:String): Observable<OverviewMovie>
    @GET("movie/{movie_id}/credits") fun getCredits(@Path("movie_id") movieId:Int, @Query("api_key") apiKey:String): Observable<CreditMovie>

}
