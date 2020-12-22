package me.alberto.findcard.data.remote.source

import me.alberto.findcard.data.domain.model.Card

interface IRemoteSource {
    suspend fun getCardDetails(cardNumber: String): Card
}