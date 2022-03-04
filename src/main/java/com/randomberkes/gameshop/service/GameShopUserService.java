package com.randomberkes.gameshop.service;

import com.randomberkes.gameshop.exception.GameShopUserNotFounrException;
import com.randomberkes.gameshop.model.GameShopUser;
import com.randomberkes.gameshop.repo.GameShopUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameShopUserService {
    private final GameShopUserRepo gameShopUserRepo;

    @Autowired
    public GameShopUserService(GameShopUserRepo gameShopUserRepo) {
        this.gameShopUserRepo = gameShopUserRepo;
    }

    public GameShopUser addGameShopUser(GameShopUser gameShopUser) {
        gameShopUser.setUserCode(UUID.randomUUID().toString());
        return gameShopUserRepo.save(gameShopUser);
    }

    public List<GameShopUser> findAllGameShopUsers() {
        return gameShopUserRepo.findAll();
    }

    public GameShopUser updateGameShopUser(GameShopUser gameShopUser) {
        return gameShopUserRepo.save(gameShopUser);
    }

    public GameShopUser findGameShopUserById(Long id) {
        return gameShopUserRepo.findGameShopUserById(id)
                .orElseThrow(() -> new GameShopUserNotFounrException("User by id " + id + " was not found"));
    }

    public void deleteGameShopUser(Long id) {
        gameShopUserRepo.deleteGameShopUserById(id);
    }
}
