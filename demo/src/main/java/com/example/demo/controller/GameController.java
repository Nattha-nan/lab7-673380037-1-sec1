package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    // Constructor Injection
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // ==========================
    // READ
    // แสดงรายการเกมทั้งหมด
    // GET /games
    // ==========================
    @GetMapping
    public String listGames(Model model) {

        model.addAttribute("games", gameService.getAllGames());

        return "games/list";
    }

    // ==========================
    // CREATE
    // หน้าเพิ่มเกม
    // GET /games/add
    // ==========================
    @GetMapping("/add")
    public String addGameForm(Model model) {

        model.addAttribute("game", new Game());

        return "games/add";
    }

    // ==========================
    // CREATE
    // บันทึกเกมใหม่
    // POST /games/save
    // ==========================
    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game,
                        RedirectAttributes redirectAttributes) {

        gameService.saveGame(game);

        redirectAttributes.addFlashAttribute(
                "message",
                "เพิ่มข้อมูลเกมสำเร็จ");

        return "redirect:/games";
    }

    // ==========================
    // UPDATE
    // หน้าแก้ไข
    // GET /games/edit/{id}
    // ==========================
    @GetMapping("/edit/{id}")
    public String editGame(@PathVariable Long id, Model model) {

        Game game = gameService.getGameById(id);

        if (game == null) {
            return "redirect:/games";
        }

        model.addAttribute("game", game);

        return "games/edit";
    }

    // ==========================
    // UPDATE
    // POST /games/update/{id}
    // ==========================
    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable Long id,
                            @ModelAttribute Game game,
                            RedirectAttributes redirectAttributes) {

        gameService.updateGame(id, game);

        redirectAttributes.addFlashAttribute(
                "message",
                "แก้ไขข้อมูลสำเร็จ");

        return "redirect:/games";
    }

    // ==========================
    // DELETE
    // หน้ายืนยันการลบ
    // GET /games/delete/{id}
    // ==========================
    @GetMapping("/delete/{id}")
    public String deleteGameForm(@PathVariable Long id,
                                 Model model) {

        Game game = gameService.getGameById(id);

        if (game == null) {
            return "redirect:/games";
        }

        model.addAttribute("game", game);

        return "games/delete";
    }

    // ==========================
    // DELETE
    // ลบจริง
    // POST /games/delete/{id}
    // ==========================
    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id,
                            RedirectAttributes redirectAttributes) {

        gameService.deleteGame(id);

        redirectAttributes.addFlashAttribute(
                "message",
                "ลบข้อมูลสำเร็จ");

        return "redirect:/games";
    }

}