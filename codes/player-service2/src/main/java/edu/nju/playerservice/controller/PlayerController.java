package edu.nju.playerservice.controller;


import edu.nju.playerservice.model.Player;
import edu.nju.playerservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService ;
    }

    @GetMapping("/getPlayer/{id}")
    public ResponseEntity<Object> getPlayer(@PathVariable int id) {
        return ResponseEntity.status(200).body(playerService.getPlayer(id));
    }


    @PostMapping("/addPlayer")
    public String addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }





}
