# Scarletを利用したAndroidでのWebSocket通信

## WebSocket送信結果を確認するには

wscatを利用する。

npｍでwscatをインストール。

以下のコマンドでWebSocketの受信内容を表示する。
```
 wscat --listen 8080
```

##　参考サイト

* 本家  
https://github.com/Tinder/Scarlet

* coroutinesによる受信監視
https://github.com/Tinder/Scarlet/issues/114
