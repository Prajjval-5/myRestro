import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/product.service';
import { UpdateProductComponent } from '../update-product/update-product.component';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

    
  product: Product[] = [];

  constructor(private productService:ProductService,
    private router:Router) { }

  ngOnInit(): void {
    this.getProduct(); // id, fn, ln, emId

  }
  private getProduct(){
  this.productService.getProductList().subscribe( data => {
    this.product=data;
  })
  }
  updateProduct(productId:number){
  this.router.navigate(['update-product',productId]);

  }
  deleteProduct(productId: number){
    this.productService.deleteProduct(productId).subscribe( data => {
      console.log(data);
      this.deleteProduct(productId);
    })
  }
}
