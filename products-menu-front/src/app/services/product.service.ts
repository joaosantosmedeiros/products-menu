import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

export type Response = {
  status: boolean;
  message: String;
  data: Product[];
};

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl: string = '';
  private response: Response | any = '';

  constructor(private http: HttpClient) {
    this.baseUrl = environment.api;
  }

  getProducts(): Observable<Response> {
    this.response = this.http.get<Response>(this.baseUrl, {});
    return this.response;
  }
}
