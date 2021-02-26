import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppURIConstants } from '../model/app-uri-constants'
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private http: HttpClient) { }

  fetchCountryDetails() {
    return this.http
      .get(AppURIConstants.COUNTRY_URL, { headers: this.getHeader() })
      .pipe(
        map((data: any) => {
          return data;
        })
      );
  }

  fetchCountryByName(country: string) {
    return this.http
      .get(AppURIConstants.COUNTRY_URL + country, { headers: this.getHeader() })
      .pipe(
        map((data: any) => {
          return data;
        })
      );

  }

  getHeader() {
    let header = new HttpHeaders();
    header.set("Content-Type", "application-json")
    return header;
  }
}
