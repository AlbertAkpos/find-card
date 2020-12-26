package me.alberto.findcard.screen.findcard.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import me.alberto.findcard.R

@BindingAdapter("app:scheme")
fun ImageView.cardScheme(scheme: String?) {
    when (scheme?.toLowerCase()) {
        context.getString(R.string.visa) -> {
            setImageResource(R.drawable.ic_visa_logo)
        }
        context.getString(R.string.mastercard) -> {
            setImageResource(R.drawable.ic_master_card_logo)
        }

        context.getString(R.string.american_express) -> {
            setImageResource(R.drawable.ic_american_express)
        }

        context.getString(R.string.discover) -> {
            setImageResource(R.drawable.ic_discover_card)
        }

        else -> {
            setImageResource(R.drawable.ic_default_logo)
        }
    }
}

@BindingAdapter("app:prepaidStatus")
fun TextView.prepaidOrNot(prepaid: Boolean?) {
    prepaid?.let {
        text = if (prepaid) {
            context.getString(R.string.prepaid)
        } else {
            context.getString(R.string.postpaid)
        }
    }
}

@BindingAdapter("app:cardBackground")
fun MaterialCardView.background(scheme: String?) {
    when (scheme?.toLowerCase()) {
        context.getString(R.string.visa) -> {
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.secondaryLightColor))
        }
        context.getString(R.string.mastercard) -> {
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.secondaryDarkColor))
        }

        context.getString(R.string.american_express) -> {
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.faint_white))
        }

        context.getString(R.string.discover) -> {
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.secondaryDarkColor))
        }

        else -> {
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.secondaryDarkColor))
        }
    }
}