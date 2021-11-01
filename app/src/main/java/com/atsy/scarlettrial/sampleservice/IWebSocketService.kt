package com.atsy.scarlettrial.sampleservice

import com.atsy.scarlettrial.models.Message
import com.tinder.scarlet.ws.Send

interface IWebSocketService {

    @Send
    fun sendMessage(message: Message): Boolean
}