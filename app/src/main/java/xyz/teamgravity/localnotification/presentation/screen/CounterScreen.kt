package xyz.teamgravity.localnotification.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.localnotification.R
import xyz.teamgravity.localnotification.presentation.viewmodel.CounterViewModel

@Composable
fun CounterScreen(
    viewmodel: CounterViewModel = hiltViewModel(),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = viewmodel::onShowNotification) {
            Text(text = stringResource(id = R.string.show_notification))
        }
    }
}