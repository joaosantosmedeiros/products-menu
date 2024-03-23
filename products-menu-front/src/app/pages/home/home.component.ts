import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  products: Product[] = [];

  constructor(private service: ProductService) {}

  ngOnInit(): void {
    this.service.getProducts().subscribe({
      next: (res) => {
        if (res.status) {
          res.data.forEach((product) => this.products.push(product));
        }
      },
      error: (err) => console.log(err),
    });
  }
}
