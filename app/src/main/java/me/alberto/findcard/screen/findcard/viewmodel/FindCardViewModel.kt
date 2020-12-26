package me.alberto.findcard.screen.findcard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.alberto.findcard.data.domain.model.Card
import me.alberto.findcard.data.domain.usecase.GetCardDetailsUseCase
import me.alberto.findcard.data.remote.mapper.toDomain
import me.alberto.findcard.util.State
import retrofit2.HttpException
import javax.inject.Inject

class FindCardViewModel @Inject constructor(private val getCardDetailsUseCase: GetCardDetailsUseCase) :
    ViewModel() {
    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card> = _card
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    /**
     * Gets card details from remote
     * @param cardNumber number typed in by user
     */
    fun getCardDetails(cardNumber: String) {
        if (cardNumber.length < 6 || cardNumber.length > 9) return
        viewModelScope.launch {
            try {
                _state.postValue(State.Loading)
                val result = getCardDetailsUseCase.execute(cardNumber)
                val formattedNumber = formatCardNumber(cardNumber, result.number?.length?.toInt())
                val cardDomain = result.toDomain(formattedNumber)
                _card.postValue(cardDomain)
                _state.postValue(State.Success(cardDomain))
            } catch (exp: Exception) {
                if (exp is HttpException) {
                    _state.postValue(State.Error("Card number might not be valid"))
                } else {
                    _state.postValue(State.Error(exp.message ?: "Some error occurred"))
                }
                exp.printStackTrace()
            }
        }
    }


    /**
     * A util function to properly format card number
     * @param cardNumber 6-9 digits of user card
     * @param cardNumberSize the value of card number length returned from api
     */
    private fun formatCardNumber(cardNumber: String, cardNumberSize: Int?): String {
        val padding = cardNumberSize?.minus(cardNumber.length)
        val defaultPadding = 7
        var _cardNumber = cardNumber
        var formattedNumber = ""
        repeat(padding ?: defaultPadding) { _cardNumber += "X" }
        _cardNumber.chunked(4) { formattedNumber += "$it  " }
        return formattedNumber.trim()
    }

}