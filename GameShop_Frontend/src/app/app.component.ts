import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GameShopUser } from './gameShopUser';
import { GameShopUserService } from './gameShopUser.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  public gameShopUsers!: GameShopUser[];

  constructor(private gameShopUserService: GameShopUserService){}

  ngOnInit(): void {
      this.getGameShopUsers();
  }

  public getGameShopUsers(): void {
    this.gameShopUserService.getAllGameShopUsers().subscribe(
      (response: GameShopUser[]) => {
        this.gameShopUsers = response;
        console.log(this.gameShopUsers);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }
}  
