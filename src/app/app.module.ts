import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {PlaceService} from './services/place.service';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PlacelistComponent } from './placelist/placelist.component';


@NgModule({
  declarations: [
    AppComponent,
    PlacelistComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [PlaceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
