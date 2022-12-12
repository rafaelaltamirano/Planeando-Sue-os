package com.example.planeando_suenos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planeando_suenos.ui.main.MainModel
import com.example.planeando_suenos.ui.router.Router
import com.example.planeando_suenos.ui.theme.PlaneandosuenosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComponent()
        }
    }
}

@Composable
fun MainComponent(mainModel: MainModel = viewModel()) {
    Surface(color = White) {
        Router(mainModel)
    }
}
