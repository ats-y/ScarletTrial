package com.atsy.scarlettrial.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atsy.scarlettrial.models.Message

class MainActivityViewModel : ViewModel() {

    var messages = mutableStateListOf<Message>()
}