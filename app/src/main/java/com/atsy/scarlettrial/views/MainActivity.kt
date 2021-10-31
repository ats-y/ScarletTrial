package com.atsy.scarlettrial.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
        vm.buildWebSocket(application)

        setContent {
            ScarletTrialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Main(vm.messages, onSend = vm::send)
                }
            }
        }
    }
}

@Composable
fun Main(
    messageList: List<Message>,
    onSend : (sendMessage: String) -> Unit
){
    var sendText by remember { mutableStateOf("")}

    Column(
        Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = sendText,
                onValueChange = { sendText = it },
                modifier = Modifier
                    .weight(1.0f),
                label = { Text("送信文字")}
            )

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = { onSend(sendText) },
            ) {
                Text(text = "Send")
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
        Main(listOf(Message("aaa"), Message("bbb")),
            onSend = { /* nothing */ }
            )
    }
}