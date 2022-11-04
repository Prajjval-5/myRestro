import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AddProductComponent } from './pages/add-product/add-product.component';
import { UpdateProductComponent } from './pages/update-product/update-product.component';
import { UserComponent } from './pages/user/user.component';
import { ViewProductComponent } from './pages/view-product/view-product.component';
import { RegisterComponent } from './Auth/register/register.component';
import { LoginComponent } from './Auth/login/login.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"addProduct",component:AddProductComponent},
  {path:"viewProduct",component:ViewProductComponent},
  {path:"update-product/:productId",component:UpdateProductComponent},
  {path:"User",component:UserComponent},
  {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
