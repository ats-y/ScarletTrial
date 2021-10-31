package com.atsy.scarlettrial.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.atsy.scarlettrial.models.Message
import com.atsy.scarlettrial.ui.theme.ScarletTrialTheme
import com.atsy.scarlettrial.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm : MainActivityViewModel by viewModels()

        setContent {
            ScarletTrialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Main(vm.messages)
                }
            }
        }
    }
}

@Composable
fun Main(messageList: List<Message>){
    Column(
        Modifier.fillMaxSize()
    ) {
        Row() {
            Button(
                onClick = {}
            ) {
                Text(text = "Connect")
            }
            Spacer(
                Modifier.width(10.dp)
            )
            Button(
                onClick = {}
            ) {
                Text(text = "Disonnect")
            }
        }

        LazyColumn {
            items(messageList){ message ->
                Text(text = message.text)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScarletTrialTheme {
        Main(listOf(Message("aaa"), Message("bbb")))
    }
}