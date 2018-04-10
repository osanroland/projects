import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Place} from '../place/place.model';

@Injectable()
export class PlaceService {

  constructor(private http: HttpClient) {
  }

private placeUrl = 'http://localhost:8080/api/places';

  getAll(): Observable<any> {
    return this.http.get(this.placeUrl);
  }

  getByType(type: string): Observable<any> {
  return this.http.get(this.placeUrl + '/' + type);
  }
}

