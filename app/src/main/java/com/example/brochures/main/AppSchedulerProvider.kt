package com.example.brochures.main

import com.example.brochures.main.SchedulerProvider
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Default RxJava schedulers
 *
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class AppSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}