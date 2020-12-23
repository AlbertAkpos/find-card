package me.alberto.findcard.data.domain.usecase

import me.alberto.findcard.data.domain.repository.IRepository
import me.alberto.findcard.data.remote.model.CardResponse
import javax.inject.Inject

class GetCardDetailsUseCase @Inject constructor(private val repository: IRepository) :
    UseCase<CardResponse, String>() {
    override suspend fun buildUseCase(params: String?): CardResponse {
        requireNotNull(params) { "Params cannot be null" }
        return repository.getCardDetails(params)
    }
}