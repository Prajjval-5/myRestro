import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';
@Injectable({
    providedIn: 'root'
})
export class ProductService {

     // From localhost:4200 ---> localhost:8080 ===> grab employeeDetails
    private baseURL="http://localhost:8080/product"

    
    constructor(private httpClient: HttpClient) { }

    getProductList(): Observable<Product[]>{
        return this.httpClient.get<Product[]>(`${this.baseURL}/get`);
    }
    //Create/add Employee
    createProduct(product:Product):Observable<Object>{
        return this.httpClient.post(`${this.baseURL}/add`, product);
    }
    getProductById(productId: number): Observable<Product>{
        return this.httpClient.get<Product>(`${this.baseURL}/${productId}`);
    }
    
    updateProduct(productId: number, product: Product): Observable<Object>{
        return this.httpClient.put(`${this.baseURL}/${productId}`, product);
    }
    deleteProduct(productId: number): Observable<Object>{
        return this.httpClient.delete(`${this.baseURL}/${productId}`);
    }
}
