import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HttpClientModule, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [ProductService],
})
export class AppComponent {
  title = 'products-menu-front';

  constructor(private http: HttpClient) {}
}
