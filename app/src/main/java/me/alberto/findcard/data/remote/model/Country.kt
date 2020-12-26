package me.alberto.findcard.data.remote.model

import com.google.gson.annotations.SerializedName

data class _Country(
    @SerializedName("numeric")
    val numeric: String?,
    @SerializedName("alpha2")
    val alpha2: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("emoji")
    val emoji: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?
)