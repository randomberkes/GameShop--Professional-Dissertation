package com.randomberkes.gameshop.controller;

import com.randomberkes.gameshop.model.GameShopUser;
import com.randomberkes.gameshop.service.GameShopUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameShopUser")
public class GameShopUserController {
    public final GameShopUserService gameShopUserService;

    public GameShopUserController(GameShopUserService gameShopUserService) {
        this.gameShopUserService = gameShopUserService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<GameShopUser>> getAllGameShopUsers (){
        List<GameShopUser> gameShopUsers = gameShopUserService.findAllGameShopUsers();
        return new ResponseEntity<>(gameShopUsers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GameShopUser> getGameShopUserById (@PathVariable("id") Long id){
        GameShopUser gameShopUser = gameShopUserService.findGameShopUserById(id);
        return new ResponseEntity<>(gameShopUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GameShopUser> addGameShopUser(@RequestBody GameShopUser gameShopUser){
        GameShopUser newGameShopUser = gameShopUserService.addGameShopUser(gameShopUser);
        return new ResponseEntity<>(newGameShopUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<GameShopUser> updateGameShopUser(@RequestBody GameShopUser gameShopUser){
        GameShopUser updateGameShopUser = gameShopUserService.updateGameShopUser(gameShopUser);
        return new ResponseEntity<>(updateGameShopUser, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> updateGameShopUser(@PathVariable("id") Long id){
        gameShopUserService.deleteGameShopUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }








}
