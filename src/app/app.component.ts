import { Component } from '@angular/core';
import { PlacelistComponent } from './placelist/placelist.component';
import {PlaceService} from './services/place.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';


}
