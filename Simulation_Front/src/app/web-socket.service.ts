import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client'
import { CanvasComponent } from './canvas/canvas.component';

// @Injectable({
//   providedIn: 'root'
// })
export class WebSocketService {
  webSocketEndPoint: string = 'http://localhost:8080/ws'
  stompClient: any;
  topic: string = "/topic/greetings"
  canvasComponent: CanvasComponent;

  constructor(canvasComponent: CanvasComponent) {this.canvasComponent = canvasComponent}

  _connect() {
    // let ws = new SockJS(this.webSocketEndPoint);
    // this.stompClient = Stomp.over(ws);
    const _this = this;
    _this.stompClient.connect({}, function (frame) {
        _this.stompClient.subscribe(_this.topic, function (sdkEvent) {
          // _this.onMessageReceived(sdkEvent);
        });
        //_this.stompClient.reconnect_delay = 2000;
    }, this.errorCallBack);
  };

  errorCallBack() {
    setTimeout(() => {
        this._connect();
    }, 5000);
}


  /*onMessageReceived(message) {
    console.log("Message Recieved from Server :: " + message);
    this.appComponent.handleMessage(JSON.stringify(message.body));
  }*/

}