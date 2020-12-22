package me.alberto.findcard.data.domain.model

import com.google.gson.annotations.SerializedName

data class CardNumber(
    val length: Long?,
    val luhn: Boolean?
)
