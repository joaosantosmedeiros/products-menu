import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { NewComponent } from './pages/new/new.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'new', component: NewComponent },
];
