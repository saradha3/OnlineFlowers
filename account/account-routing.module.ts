import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './account.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from '../admin/admin.component';
import { UserComponent } from '../user/user.component';
import { AdminGuard } from '../admin.guard';
import { NormalGuard } from '../normal.guard';
import { FlowersComponent } from './flowers/flowers.component';
import { FlowerdetailsComponent } from './flowerdetails/flowerdetails.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { CartComponent } from './cartempty/cart.component';
import { MyordersComponent } from './myorders/myorders.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ShopallflowersComponent } from './shopallflowers/shopallflowers.component';
import { ContactformComponent } from './contactform/contactform.component';

const routes: Routes = [
  { path: '', component: AccountComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'admin', component: AdminComponent, canActivate: [AdminGuard]},
  { path: 'normal', component: UserComponent, canActivate: [NormalGuard]},
  { path: 'flowers/:title', component: FlowersComponent},
  { path: 'flowerdetails/:title', component: FlowerdetailsComponent},
  { path: 'checkout', component: CheckoutComponent, canActivate: [NormalGuard]},
  { path: 'cartempty', component: CartComponent},
  { path: 'myorders', component: MyordersComponent, canActivate: [NormalGuard]},
  { path: 'forgotpassword', component: ForgotpasswordComponent},
  { path: 'shopallflowers', component: ShopallflowersComponent},
  { path: 'contactform', component: ContactformComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
