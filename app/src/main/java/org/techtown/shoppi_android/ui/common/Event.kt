package org.techtown.shoppi_android.ui.common

import androidx.lifecycle.Observer

/**
 * android architecture-samples
 * https://github.com/android/architecture-samples/blob/dev-dagger/app/src/main/java/com/example/android/architecture/blueprints/todoapp/Event.kt
 **/
class Event<T>(private val content: T) {

    private var hasBeenHandled = false


    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) { // T 처리된적 있음
            null
        } else { // T 처리된적 없음
            hasBeenHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit): Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}