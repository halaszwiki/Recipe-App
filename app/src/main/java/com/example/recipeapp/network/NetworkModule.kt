package com.example.recipeapp.network

import com.example.recipeapp.network.NetworkConfig.API_ENDPOINT_ADDRESS
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }

    @Provides
    @Singleton
    fun provideRecipesApi(client: OkHttpClient): RecipeApi {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(API_ENDPOINT_ADDRESS)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        return retrofit.create(RecipeApi::class.java)
    }


}