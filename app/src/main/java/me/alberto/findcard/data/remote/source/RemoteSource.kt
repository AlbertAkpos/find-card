package me.alberto.findcard.data.remote.source

import me.alberto.findcard.data.domain.model.Card
import me.alberto.findcard.data.remote.mapper.toDomain
import me.alberto.findcard.data.remote.restclient.RestClient
import javax.inject.Inject

class RemoteSource @Inject constructor(private val restClient: RestClient) : IRemoteSource {
    override suspend fun getCardDetails(cardNumber: String): Card {
        return restClient.getRemote().getCardDetails(cardNumber).toDomain()
    }
}