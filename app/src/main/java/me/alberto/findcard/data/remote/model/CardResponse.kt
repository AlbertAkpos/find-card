package me.alberto.findcard.data.remote.model

import com.google.gson.annotations.SerializedName

data class CardResponse(
    @SerializedName("number")
    val number: _CardNumber?,
    @SerializedName("scheme")
    val scheme: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("prepaid")
    val prepaid: Boolean?,
    @SerializedName("country")
    val country: _Country?,
    @SerializedName("bank")
    val bank: _Bank?
)
