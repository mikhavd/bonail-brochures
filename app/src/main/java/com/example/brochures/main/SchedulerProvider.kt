package com.example.brochures.main

import rx.Scheduler

/**
 * Provider for schedulers RxJava
 *
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}