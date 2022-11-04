import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productId : number | any;
  product:Product= new Product();
  router: any;


    constructor(private productService:ProductService, private route:ActivatedRoute) { }

    ngOnInit(): void {
      this.productId = this.route.snapshot.params['productId'];
      this.productService.getProductById(this.productId).subscribe(data =>{
        this.product = data;
      },error => console.log(error));
    }
    
    onSubmit(){      
      //connectong the angular with the add employee 
      this.productService.updateProduct(this.productId,this.product).subscribe(data =>{
      this.goToProductList();
      }, error => console.log(error));
    }

    goToProductList(){
      this.router.navigate(['viewProduct'])
    }

}
