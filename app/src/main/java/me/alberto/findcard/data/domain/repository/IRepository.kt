package me.alberto.findcard.data.domain.repository

import me.alberto.findcard.data.remote.model.CardResponse

interface IRepository {
    suspend fun getCardDetails(cardNumber: String): CardResponse
}