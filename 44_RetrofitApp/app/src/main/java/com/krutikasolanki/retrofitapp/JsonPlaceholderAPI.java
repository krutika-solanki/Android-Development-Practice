package com.krutikasolanki.retrofitapp;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

// Retrofit will automatically Implement these interfaces
public interface JsonPlaceholderAPI {
    @GET("posts")
    Call<List<Post>> getAllPosts();

    @GET
    Call<List<Post>> getAllPosts(@Url String url);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@Field("userId") int userId,
                                @Field("title") String title,
                                @Field("body") String text
    );

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id,@Body Post post);


    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id,@Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
