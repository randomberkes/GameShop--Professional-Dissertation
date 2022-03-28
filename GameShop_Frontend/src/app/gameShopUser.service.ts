import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { GameShopUser } from './gameShopUser';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class GameShopUserService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}

    public getGameShopUserById(id: number): Observable<GameShopUser[]>{
        return this.http.get<GameShopUser[]>(`${this.apiServerUrl}/gameShopUser/find/${id}`);
    }

    public getAllGameShopUsers(): Observable<GameShopUser[]>{
        return this.http.get<GameShopUser[]>(`${this.apiServerUrl}/gameShopUser/find/all`);
    }

    public addGameShopUser(gameShopUser: GameShopUser): Observable<GameShopUser>{
        return this.http.post<GameShopUser>(`${this.apiServerUrl}/gameShopUser/add`, gameShopUser);
    }

    public updateGameShopUser(gameShopUser: GameShopUser): Observable<GameShopUser>{
        return this.http.put<GameShopUser>(`${this.apiServerUrl}/gameShopUser/update`, gameShopUser);
    }

    public deleteGameShopUser(id: number): Observable<GameShopUser>{
        return this.http.delete<GameShopUser>(`${this.apiServerUrl}/gameShopUser/delete/${id}`);
    }


}