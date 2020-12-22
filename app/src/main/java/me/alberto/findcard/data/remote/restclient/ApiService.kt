package me.alberto.findcard.data.remote.restclient

import me.alberto.findcard.data.remote.model.CardResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getCardDetails(@Url cardNumber: String): CardResponse
}
