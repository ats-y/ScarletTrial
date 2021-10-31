package com.atsy.scarlettrial.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atsy.scarlettrial.models.Message
import com.atsy.scarlettrial.repositories.MessageRepository

class MainActivityViewModel : ViewModel() {

    var messages = mutableStateListOf<Message>()
    var repo: MessageRepository? = null

    fun buildWebSocket(app: Application){
        if( repo == null ){
            repo = MessageRepository()
            repo?.build(app)
        }
    }

    fun send(sendMessage: String){

        repo?.service?.sendMessage(Message(sendMessage))
    }
}