package com.atsy.scarlettrial.repositories

import com.atsy.scarlettrial.sampleservice.IWebSocketService
import com.google.gson.Gson
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class MessageRepository {

    lateinit var service: IWebSocketService

    fun build() {

        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val gson = Gson()

        val scarlet = Scarlet.Builder()
            .webSocketFactory(client.newWebSocketFactory("ws://10.0.2.2:8080"))
            //.lifecycle(lifecycle)
            .addMessageAdapterFactory(GsonMessageAdapter.Factory(gson))
            //.addStreamAdapterFactory(RxJava2StreamAdapterFactory())
            .build()

        service = scarlet.create()
    }
}