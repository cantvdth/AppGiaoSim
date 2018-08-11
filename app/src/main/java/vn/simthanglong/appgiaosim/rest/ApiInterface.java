package vn.simthanglong.appgiaosim.rest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import vn.simthanglong.appgiaosim.rest.response.UserResponse;

/**
 * Created by CanTran on 5/23/17.
 */
public interface ApiInterface {
//    @POST("auth/register")
//    Call<UserReponse> register(@Body RequestBody body);
//
    @POST("login")
    Call<UserResponse> login(@Body RequestBody body);
//
//    @POST("auth/recover")
//    Call<Void> recoverPasswor(@Body RequestBody body);
//
//    @POST("application")
//    Call<ApplicationResponse> createApplication(@Header("Authorization") String token, @Body RequestBody body);
//
//    @POST("application/duplicate")
//    Call<ApplicationResponse> duplicateApplication(@Header("Authorization") String token, @Body RequestBody body);
//
//    @GET("application/list")
//    Call<List<ApplicationResponse>> getAllApplication(@Header("Authorization") String token);
//
//    @Multipart
//    @POST("attachment")
//    Call<List<Attachment>> uploadImage(@Header("Authorization") String token, @Part List<MultipartBody.Part> files);
//
//    @DELETE("application/{application_id}")
//    Call<Void> deleteApplication(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @GET("application/{application_id}/basic_info")
//    Call<ResponseBasicInformation> getBasicInformation(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("application/{application_id}/basic_info")
//    Call<ResponseBasicInformation> saveBasicInformation(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @GET("application/{application_id}/review/personal_info")
//    Call<PersonalInfomationResponse> getReviewPersonalInfo(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @GET("application/{application_id}/review/income")
//    Call<IncomeResponse> getReviewIncome(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("application/{application_id}/review/income")
//    Call<IncomeResponse> putReviewIncom(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @PUT("application/{application_id}/review/personal_info")
//    Call<PersonalInfomationResponse> updatePersonalInfo(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @GET("application/{application_id}/fees")
//    Call<FeeResponse> getPromotionFee(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @POST("application/{application_id}/promotion")
//    Call<FeeResponse> checkPromotionCode(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @POST("application/{application_id}/checkout")
//    Call<Void> checkout(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @GET("application/{application_id}/review/deduction")
//    Call<DeductionResponse> getReviewDeduction(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("application/{application_id}/review/deduction")
//    Call<DeductionResponse> putReviewDeduction(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @GET("application/{application_id}/review/health")
//    Call<ReviewFamilyHealthResponse> getReviewFamilyHealth(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("application/{application_id}/review/health")
//    Call<ReviewFamilyHealthResponse> updateReviewFamilyHealth(@Header("Authorization") String token, @Path("application_id") int appId, @Body RequestBody body);
//
//    @GET("application/{application_id}/review/summary")
//    Call<Summary> getReviewSummary(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("application/{application_id}/review/lodge")
//    Call<ApplicationResponse> loggeApplicaction(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @PUT("user/device")
//    Call<Void> updatePushToken(@Header("Authorization") String token, @Body RequestBody body);
//
//    @GET("notifications")
//    Call<List<Notification>> getNotitifications(@Header("Authorization") String token, @Query("since") String since, @Query("limit") int limit);
//
//    @GET("user")
//    Call<UserEntity> getUserInformation(@Header("Authorization") String token);
//
//    @POST("message")
//    Call<Message> sendMsg(@Header("Authorization") String token, @Body RequestBody body);
//
//    @GET("messages")
//    Call<List<Message>> getMsg(@Header("Authorization") String token, @Query("since") String since, @Query("limit") int limit);
//
//    @GET("user/languages")
//    Call<List<Language>> getLanguage(@Header("Authorization") String token);
//
//    @PUT("user")
//    Call<UserEntity> updateUserInformation(@Header("Authorization") String token, @Body RequestBody body);
//
//    @GET("system/status")
//    Call<UpdateResponse> checkUpdate(@Header("Authorization") String token, @Query("device") String device, @Query("current_version") String version);
//
//    @GET("user/status")
//    Call<BlockResponse> checkBlockUser(@Header("Authorization") String token);
//
//    @GET("application/{application_id}/review/progress")
//    Call<ReviewProgressResponse> getReviewProgress(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @POST("auth/logout")
//    Call<Void> logOut(@Header("Authorization") String token);
//
//    @Streaming
//    @GET
//    Call<ResponseBody> downloadFileUrlAsync(@Url String fileUrl);
//
//    @GET("system/countrycodes")
//    Call<List<CountryCodeResponse>> getCountryCodeResponse(@Header("Authorization") String token);
//
//    @GET("application/{application_id}/basic/progress")
//    Call<BaseAppProgress> getBaseProgress(@Header("Authorization") String token, @Path("application_id") int appId);
//
//    @GET("application/service_fees")
//    Call<FeeResponse> getServiceFees(@Header("Authorization") String token);

}
