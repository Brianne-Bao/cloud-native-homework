package edu.nju.playerservice.service;


import edu.nju.playerservice.dao.PlayerDao;
import edu.nju.playerservice.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerDao playerDao;

    @Autowired
    public PlayerServiceImpl(PlayerDao playerDao){
        this.playerDao = playerDao;
    }

    @Override
    public Player getPlayer(int id){
        if(id >0 ){
            return playerDao.getPlayer(id);
        }else{
            throw new RuntimeException("id不存在");
        }

    }

    @Override
    public String addPlayer(Player player){
        String res;
        Player target = playerDao.getPlayer(player.getId());
        if(target!= null){
            //已存在相同id
            res = "id已存在";
        }else{
            playerDao.addPlayer(player);
            res = "添加成功";
        }

        return res;

    }
}
