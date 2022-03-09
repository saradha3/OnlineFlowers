import { Component, OnInit } from '@angular/core';
import { data } from 'jquery';
import { LoginService } from '../account/login.service';
import { SubjectService } from '../account/subject.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public isLoggedIn: boolean = false;
  public user: any = null;
  cartItem:number = 0;
  cartEmpty: boolean = true;
  userrole: string = "";

  constructor(public login: LoginService,private subject:SubjectService) {
    this.subject.cartSubject.subscribe(
      (data:any)=>{
        this.cartItem = data;
        console.log(this.cartItem);
        if(this.cartItem!=0){
          this.cartEmpty = false;
          console.log(this.cartEmpty);
        }
        if(this.cartItem==0){
          this.cartEmpty = true;
          console.log(this.cartEmpty);
        }
      }
    );
   }

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.userrole = this.login.getUserRole();
    console.log(this.userrole);
    this.login.loginStatusSubject.asObservable().subscribe((data) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    })
    this.cartItemFunc();
  }

  public logout(){
    this.login.logout();
    window.location.href = "/";
  }

  cartItemFunc(){
    if(localStorage.getItem('localCart')!= null){
      var cartCount = JSON.parse(localStorage.getItem('localCart') || '[]');
      console.log(cartCount);
      this.cartItem = cartCount.length;
    }
    if(this.cartItem!=0){
      this.cartEmpty = false;
      console.log(this.cartEmpty);
    }
  }

}
