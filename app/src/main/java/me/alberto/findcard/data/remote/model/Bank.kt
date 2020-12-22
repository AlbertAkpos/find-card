package me.alberto.findcard.data.remote.model

import com.google.gson.annotations.SerializedName

data class _Bank(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("city")
    val city: String?
)
