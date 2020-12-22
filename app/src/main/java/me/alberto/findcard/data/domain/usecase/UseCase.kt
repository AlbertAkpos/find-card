package me.alberto.findcard.data.domain.usecase

abstract class UseCase<T, PARAMS> protected constructor() {
    protected abstract suspend fun buildUseCase(params: PARAMS?): T
    suspend fun execute(params: PARAMS? = null): T = buildUseCase(params)
}