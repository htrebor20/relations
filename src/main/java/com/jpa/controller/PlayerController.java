package com.jpa.controller;

import com.jpa.entities.Player;
import com.jpa.service.IClubService;
import com.jpa.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")

public class PlayerController{
    @Autowired
    private IPlayerService playerService;

    @GetMapping("/find/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Player> playerOptional = playerService.findById(id);
        if(playerOptional.isPresent()) {
            Player player = playerOptional.get();
            return ResponseEntity.ok(player);
        }
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
        public ResponseEntity<?> findAll() {
        List<Player> playerList = playerService.findAll();
            return  ResponseEntity.ok(playerList);
    }
    @PostMapping("/save")
        public ResponseEntity<?> save(@RequestBody Player player) throws URISyntaxException {
            if(player.getName().isBlank()) {
                    return ResponseEntity.notFound().build();
            }
                playerService.save(player);
                return ResponseEntity.created(new URI("api/player/save")).build();
    }
     @PutMapping("/update/{id}")
        public ResponseEntity<?> updatePlayer(@PathVariable Long id ,@RequestBody Player player) {
            Optional<Player> playerOptional = playerService.findById(id);
            if(playerOptional.isPresent()) {
                Player player1 = playerOptional.get();
                player1.setName(player.getName());
                playerService.save(player1);
                return ResponseEntity.ok("Registro atualizado");
            }
                return ResponseEntity.notFound().build();
     }
     @DeleteMapping("/delete/")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if(id !=null) {
            playerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
            return ResponseEntity.badRequest().build();
     }
}
