import { Component, Input, OnInit } from '@angular/core';
import { Countries } from 'src/app/model/countries';
import { CountryInfo } from 'src/app/model/countryInfo';
import { HttpServiceService } from 'src/app/services/http-service.service';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {

  // @Input() countries?:Countries;
  countryName: string = "";
  countries?: CountryInfo[];
  errorMessage: string = "";

  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.getAllCountries();
  }

  getAllCountries() {
    this.httpService.fetchCountryDetails()
      .subscribe(
        res => {
          this.countries = res.countries;
          console.log(this.countries);
          // this.countriesEvent.emit(countrieRes);
        }, err => {
          console.log(err);
          this.errorMessage = "System Error";
        }
      )
  }

  getByName() {
    this.httpService.fetchCountryByName(this.countryName)
      .subscribe(
        res => {
          this.countries = [new CountryInfo(res.name, res.country_code, res.capital, res.capital, res.flag_file_url)]
        }, err => {
          console.log(err);
          this.errorMessage = "System Error";
        }
      )
  }

  populateCountries(countries: Countries) {
    console.log(countries);
  }

}
