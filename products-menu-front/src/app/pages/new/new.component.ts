import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { environment } from '../../environments/environment';

export interface Request {
  name: string;
  description: string;
  price: number;
  isDisponible: boolean;
}

@Component({
  selector: 'app-new',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './new.component.html',
  styleUrl: './new.component.css',
})
export class NewComponent implements OnInit {
  constructor(private http: HttpClient) {}

  request: Request = {
    name: '',
    description: '',
    price: 0,
    isDisponible: true,
  };

  ngOnInit(): void {}

  createProduct() {
    const url = environment.api;
    this.http.post(url, this.request).subscribe({
      next: (res) => {
        location.replace('http://localhost:4200');
      },
      error: (err) => {
        console.log(err.error.error);
      },
    });
  }
}
