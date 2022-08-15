package xyz.teamgravity.localnotification.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.teamgravity.localnotification.core.notification.CounterNotification
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val notification: CounterNotification,
) : ViewModel() {

    fun onShowNotification() {
        notification.show()
    }
}