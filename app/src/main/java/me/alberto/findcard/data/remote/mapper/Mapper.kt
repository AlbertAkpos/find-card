package me.alberto.findcard.data.remote.mapper

import me.alberto.findcard.data.domain.model.Bank
import me.alberto.findcard.data.domain.model.Card
import me.alberto.findcard.data.domain.model.CardNumber
import me.alberto.findcard.data.domain.model.Country
import me.alberto.findcard.data.remote.model.CardResponse

fun CardResponse.toDomain(cardNumber: String): Card {
    return Card(
        cardNumber = cardNumber,
        number = CardNumber(number?.length, number?.luhn),
        type = type,
        scheme = scheme,
        bank = Bank(bank?.name, bank?.url, bank?.phone, bank?.city),
        prepaid = prepaid,
        brand = brand,
        country = Country(country?.name, country?.emoji, country?.currency)
    )
}