package me.alberto.findcard.di.scope

import javax.inject.Scope

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@Scope
annotation class AppScope