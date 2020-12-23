package me.alberto.findcard.data.domain.repository

import me.alberto.findcard.data.remote.model.CardResponse
import me.alberto.findcard.data.remote.source.IRemoteSource
import javax.inject.Inject

class Repository @Inject constructor(private val remoteSource: IRemoteSource) : IRepository {
    override suspend fun getCardDetails(cardNumber: String): CardResponse {
        return remoteSource.getCardDetails(cardNumber)
    }
}