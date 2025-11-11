package me.rohinee.todo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AppScreen(viewModel: MainViewModel) {
    val data = viewModel.data()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background)
    {
      Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier.fillMaxSize())
      {
          Text(
              text = data,
              style = MaterialTheme.typography.headlineMedium)
      }
    }


}
