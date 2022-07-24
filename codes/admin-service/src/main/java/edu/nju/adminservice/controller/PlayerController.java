package edu.nju.adminservice.controller;

import edu.nju.adminservice.dto.PlayerDto;
import edu.nju.adminservice.service.GuavaRateLimiterService;
import edu.nju.adminservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author LianJianheng
 * @version 1.0.0
 * @createTime 2022/7/16
 * @Description TODO
 */
@RestController
public class PlayerController
{
    @Autowired
    private final PlayerService playerService;
    @Autowired
    private final GuavaRateLimiterService rateLimiterService;

    public PlayerController(PlayerService playerService, GuavaRateLimiterService rateLimiterService) {
        this.playerService = playerService;
        this.rateLimiterService = rateLimiterService;
    }

    @GetMapping("/getPlayer/{id}")
    public ResponseEntity<Object> getPlayer(@PathVariable int id)
    {
        if(!rateLimiterService.tryAcquire()) {
            return ResponseEntity.status(429).body("{\"code\": 429, \"msg\": \"Too many requests!\"}");
        }
        return playerService.getPlayer(id);
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@RequestBody PlayerDto player)
    {
        return playerService.addPlayer(player);
    }
}
