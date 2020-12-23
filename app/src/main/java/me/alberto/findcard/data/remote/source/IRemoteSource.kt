package me.alberto.findcard.data.remote.source

import me.alberto.findcard.data.remote.model.CardResponse

interface IRemoteSource {
    suspend fun getCardDetails(cardNumber: String): CardResponse
}