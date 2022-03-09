import { Component, OnInit } from '@angular/core';
import { LoginService } from '../account/login.service';
import { UserService } from '../account/user.service';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user:any = null;

  selectedFile!: File
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string = "";
  imageName: any;

  
  constructor(private login: LoginService, private userService: UserService) { }

  ngOnInit(): void {
    this.user = this.login.getUser();

    this.userService.getUserdp(this.user.username).subscribe(
      (data: any)=>{
        console.log(data);
       // let objectURL = 'data:image/jpeg;base64,' + data.image;       
           // this.retrievedImage = this.sanitizer.bypassSecurityTrustUrl(data);
        this.retrieveResonse = data;
          this.base64Data = this.retrieveResonse.dp;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
          console.log(this.retrievedImage);
      },
      (error: any)=>{
        console.log(error);
      }
    )
  }

  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
  }


  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);
    
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    console.log(uploadImageData);

    this.userService.updateUserdp(this.user.username,uploadImageData).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Uploaded Successfully");
      },
      (error) => {
        console.log(error);
      }
    )

  }

  savefirstname(): any{
    this.userService.updateUserfirstname(this.user.username,this.user.firstname).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Firstname changed successfully");
      },
      (error) => {
        console.log(error);
      }
    )
  }

  savelastname(): any{
    this.userService.updateUserlastname(this.user.username,this.user.lastname).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Lastname changed successfully");
      },
      (error) => {
        console.log(error);
      }
    )

  }

  saveaddress(): any{
    this.userService.updateUseraddress(this.user.username,this.user.address).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Address changed successfully");
      },
      (error) => {
        console.log(error);
      }
    )
    
  }

  saveemail(): any{
    this.userService.updateUseremail(this.user.username,this.user.email).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Email changed successfully");
      },
      (error) => {
        console.log(error);
      }
    )
  }

  savephone(): any{
    this.userService.updateUserphone(this.user.username,this.user.phone).subscribe(
      (data: any)=>{
        console.log(data);
        alert("Phone number changed successfully");
      },
      (error) => {
        console.log(error);
      }
    )
  }

}
