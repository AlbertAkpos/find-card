package me.alberto.findcard.data.remote.model

import com.google.gson.annotations.SerializedName

data class _CardNumber(
    @SerializedName("length")
    val length: Long?,
    @SerializedName("luhn")
    val luhn: Boolean?
)
