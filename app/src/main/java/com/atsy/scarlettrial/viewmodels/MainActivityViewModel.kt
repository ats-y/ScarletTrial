package com.atsy.scarlettrial.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atsy.scarlettrial.models.Message
import com.atsy.scarlettrial.repositories.MessageRepository

class MainActivityViewModel : ViewModel() {

    var messages = mutableStateListOf<Message>()
    var repo: MessageRepository? = null

    fun send(sendMessage: String){
        if( repo == null ){
            repo = MessageRepository()
            repo?.build()
        }
        repo?.service?.sendMessage(Message(sendMessage))
    }
}