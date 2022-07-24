package edu.nju.adminservice.feign;

import edu.nju.adminservice.dto.PlayerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
@Component
@FeignClient("player-service")
public interface PlayerFeign
{
    @GetMapping("/getPlayer/{id}")
    ResponseEntity<Object> getPlayer(@PathVariable int id);

    @PostMapping("/addPlayer")
    String addPlayer(@RequestBody PlayerDto player);
}
