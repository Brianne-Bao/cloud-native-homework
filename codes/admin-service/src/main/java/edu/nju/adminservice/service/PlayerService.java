package edu.nju.adminservice.service;

import edu.nju.adminservice.dto.PlayerDto;
import edu.nju.adminservice.feign.PlayerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author LianJianheng
 * @version 1.0.0
 * @createTime 2022/7/16
 * @Description TODO
 */
@Service
public class PlayerService
{
    @Autowired
    PlayerFeign playerFeign;

    public ResponseEntity<Object> getPlayer(@PathVariable int id)
    {
        return playerFeign.getPlayer(id);
    }

    public String addPlayer(@RequestBody PlayerDto player)
    {
        return playerFeign.addPlayer(player);
    }
}
