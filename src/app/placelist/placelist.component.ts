import { Component, OnInit } from '@angular/core';
import {PlaceService} from '../services/place.service';
@Component({
  selector: 'app-placelist',
  templateUrl: './placelist.component.html',
  styleUrls: ['./placelist.component.css']
})
export class PlacelistComponent implements OnInit {

  places: Array<any>;

  constructor(private placeService: PlaceService) { }

  ngOnInit() {
    this.placeService.getAll().subscribe(data => {
      this.places = data;
    });
  }
  getPlaceByType(type: string) {
      this.placeService.getByType(type).subscribe(data => {
      this.places = data;
    });
        }
}

