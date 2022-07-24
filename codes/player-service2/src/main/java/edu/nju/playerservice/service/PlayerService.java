package edu.nju.playerservice.service;


import edu.nju.playerservice.model.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    /**
     * 跟据id获取用户
     * @param id
     * @return
     */
    Player getPlayer(int id);

    /**
     * 增加一个用户
     * @param player
     * @return
     */
    String addPlayer(Player player);

}
