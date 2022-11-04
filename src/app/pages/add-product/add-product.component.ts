import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/product.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  
  product:Product= new Product();

    constructor(private productService:ProductService, private router:Router) { 
      
    }

    ngOnInit(): void {
    }
    //SaveEmployee()
    saveProduct(){
      this.productService.createProduct(this.product).subscribe(data =>{
        console.log(data);
        this.goToProductList();
      },error => console.log(error));
    }

    goToProductList(){
      this.router.navigate(['viewProduct'])
    }

    onSubmit(){
      console.log(this.product);
      //connectong the angular with the add employee 
      this.saveProduct();
    }

}
