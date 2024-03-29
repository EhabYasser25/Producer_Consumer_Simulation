import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CanvasComponent } from './canvas/canvas.component';
import { HttpService } from './Http/http.service';
import { ProxyService } from './ProxyService/proxy.service';

@NgModule({
  declarations: [
    AppComponent,
    CanvasComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule       
  ],
  providers: [HttpService, ProxyService, CanvasComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
