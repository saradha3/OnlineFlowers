import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { AccountComponent } from './account.component';
import { RegisterComponent } from './register/register.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './user.service';
import { LoginComponent } from './login/login.component';
import {MatCardModule} from '@angular/material/card';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { LoginService } from './login.service';
import { AuthInterceptorProviders } from './auth.interceptor';
import { AdminModule } from '../admin/admin.module';
import { UserModule } from '../user/user.module';
import { CarouselComponent } from './selectors/carousel/carousel.component';
import { DisplaycategoriesComponent } from './selectors/displaycategories/displaycategories.component';
import { CategoryserviceService } from '../admin/categoryservice.service';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { FlowersComponent } from './flowers/flowers.component';
import { FlowerserviceService } from '../admin/flowerservice.service';
import { FiltersComponent } from './selectors/filters/filters.component';
import {MatDividerModule} from '@angular/material/divider';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatChipsModule} from '@angular/material/chips';
import { SortbyPipe } from './Pipes/sortby.pipe';
import { FlowerdetailsComponent } from './flowerdetails/flowerdetails.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { OrderService } from './order.service';
import { CartComponent } from './cartempty/cart.component';
import { MatListModule } from '@angular/material/list';
import { MyordersComponent } from './myorders/myorders.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ShopallflowersComponent } from './shopallflowers/shopallflowers.component';
import { ContactformComponent } from './contactform/contactform.component';



@NgModule({
  declarations: [
    AccountComponent,
    RegisterComponent,
    LoginComponent,
    CarouselComponent,
    DisplaycategoriesComponent,
    FlowersComponent,
    FiltersComponent,
    SortbyPipe,
    FlowerdetailsComponent,
    CheckoutComponent,
    CartComponent,
    MyordersComponent,
    ChangepasswordComponent,
    ForgotpasswordComponent,
    ShopallflowersComponent,
    ContactformComponent,
    
    
  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatSnackBarModule,
    AdminModule,
    UserModule,
    MatIconModule,
    MatButtonModule,
    MatDividerModule,
    MatCheckboxModule,
    MatChipsModule,
    MatListModule
  ],
  exports: [ LoginComponent, RegisterComponent, MatSnackBarModule, AccountComponent, ChangepasswordComponent],
  providers: [UserService, LoginService, AuthInterceptorProviders, CategoryserviceService, FlowerserviceService, OrderService]
})
export class AccountModule { }
