package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;

@Service
public class GameService {

    private final GameRepository gameRepository;

    // Constructor Injection
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // แสดงเกมทั้งหมด
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // ค้นหาเกมตาม id
    public Game getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElse(null);
    }

    // เพิ่มเกมใหม่
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    // แก้ไขเกม
    public void updateGame(Long id, Game game) {

        Game oldGame = getGameById(id);

        if (oldGame != null) {
            oldGame.setTitle(game.getTitle());
            oldGame.setGenre(game.getGenre());
            oldGame.setPlatform(game.getPlatform());
            oldGame.setRating(game.getRating());
            oldGame.setReleaseDate(game.getReleaseDate());
            oldGame.setPrice(game.getPrice());
            oldGame.setDiscountType(game.getDiscountType());

            gameRepository.save(oldGame);
        }
    }

    // ลบเกม
    public void deleteGame(Long id) {

        Game game = getGameById(id);

        if (game != null) {
            gameRepository.delete(game);
        }
    }

}