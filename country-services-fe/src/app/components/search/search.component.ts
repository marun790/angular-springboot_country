import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Countries } from 'src/app/model/countries';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  country: string = "";
  @Output() countriesEvent:EventEmitter<Countries> = new EventEmitter();;

  getDetails = () => {

    alert(this.country);
  }

  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.httpService.fetchCountryDetails()
      .subscribe(res => {
        let countrieRes: Countries = res.countries;
        console.log(countrieRes);
        this.countriesEvent.emit(countrieRes);
      })
  }

}
