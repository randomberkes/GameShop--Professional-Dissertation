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

  public openModal( gameShopUser: GameShopUser, mode: string): void {
    if (gameShopUser !== null) {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add'){
        button.setAttribute('data-target', '#addGameShopUser');
      }
      if (mode === 'edit'){
        button.setAttribute('data-target', '#addGameShopUser');
      }
      if (mode === 'delete'){
        button.setAttribute('data-target', '#addGameShopUser');
      }
      container!.appendChild(button);
      button.click();
    }
  }
}  
