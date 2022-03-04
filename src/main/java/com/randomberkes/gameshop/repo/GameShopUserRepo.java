package com.randomberkes.gameshop.repo;

import com.randomberkes.gameshop.model.GameShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameShopUserRepo extends JpaRepository<GameShopUser, Long> {
    void deleteGameShopUserById(Long id);

    Optional<GameShopUser> findGameShopUserById(Long id);
}
