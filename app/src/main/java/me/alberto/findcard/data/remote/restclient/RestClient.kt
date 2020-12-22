package me.alberto.findcard.data.remote.restclient

import com.google.gson.GsonBuilder
import me.alberto.findcard.BuildConfig
import me.alberto.findcard.util.Urls
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    companion object {
        private const val TIMEOUT: Long = 50
        private val gson = GsonBuilder().create()
    }

    private val api: ApiService

    init {
        val loggingInterceptor = makeLoggingInterceptor(BuildConfig.DEBUG)
        val httpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)
                addInterceptor(loggingInterceptor)
            }

        val client = httpClient.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    private fun makeLoggingInterceptor(debug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (debug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    fun getRemote(): ApiService = api
}