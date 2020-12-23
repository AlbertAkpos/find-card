package me.alberto.findcard.util

import me.alberto.findcard.data.domain.model.Card

object Urls {
    const val BASE_URL = "https://lookup.binlist.net/"
}

sealed class State {
    object Loading : State()
    data class Error(val error: String) : State()
    data class Success(val card: Card) : State()
}

const val SHARED_PREF = "find_card_pref"
const val TOOL_TIP_PREF = "tool_tip_pref"

const val ACCEPTED_CARD_NUMBER_RANGE = 9