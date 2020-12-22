package me.alberto.findcard.data.domain.model

data class Card(
    val number: CardNumber?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank?
)
