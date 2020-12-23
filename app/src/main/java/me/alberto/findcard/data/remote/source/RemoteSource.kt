package me.alberto.findcard.data.remote.source

import me.alberto.findcard.data.remote.model.CardResponse
import me.alberto.findcard.data.remote.restclient.RestClient
import javax.inject.Inject

class RemoteSource @Inject constructor(private val restClient: RestClient) : IRemoteSource {
    override suspend fun getCardDetails(cardNumber: String): CardResponse {
        return restClient.getRemote().getCardDetails(cardNumber)
    }
}