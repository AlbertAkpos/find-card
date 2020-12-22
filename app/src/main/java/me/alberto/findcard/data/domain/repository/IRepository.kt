package me.alberto.findcard.data.domain.repository

import me.alberto.findcard.data.domain.model.Card

interface IRepository {
    suspend fun getCardDetails(cardNumber: String): Card
}