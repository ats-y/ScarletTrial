package com.atsy.scarlettrial.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atsy.scarlettrial.models.Message
import com.atsy.scarlettrial.repositories.MessageRepository
import timber.log.Timber

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

        if(repo?.sendMessage(Message(sendMessage)) != true){
            Timber.d("false")
        }
    }
}