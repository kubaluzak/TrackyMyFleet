import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {VehicleListComponent} from './vehicle-list/vehicle-list.component';
import {FormsModule} from '@angular/forms';
import { MapComponent } from './map/map.component';
import {LocationService} from './services/location.service';


@NgModule({
  declarations: [AppComponent, VehicleListComponent, MapComponent],
  imports: [BrowserModule, FormsModule, ],
  providers: [LocationService],
  bootstrap: [AppComponent],
})
export class AppModule {}
