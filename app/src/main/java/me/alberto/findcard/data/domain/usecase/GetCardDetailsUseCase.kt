package me.alberto.findcard.data.domain.usecase

import me.alberto.findcard.data.domain.model.Card
import me.alberto.findcard.data.domain.repository.IRepository
import javax.inject.Inject

class GetCardDetailsUseCase @Inject constructor(private val repository: IRepository) :
    UseCase<Card, String>() {
    override suspend fun buildUseCase(params: String?): Card {
        requireNotNull(params) { "Params cannot be null" }
        return repository.getCardDetails(params)
    }
}