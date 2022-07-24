package edu.nju.playerservice;

import edu.nju.playerservice.dao.PlayerDao;
import edu.nju.playerservice.model.Player;
import edu.nju.playerservice.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserServiceApplicationTests
{

    @Autowired
    PlayerDao playerDao;
    @Autowired
    PlayerService playerService;

    @Test
    void contextLoads()
    {

    }


    @Test
    @Transactional
    @Rollback
    public void PlayerDaoTestGet(){
        //dao test get
        Player test1 = playerDao.getPlayer(4);
        Assertions.assertEquals(8,test1.getNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void PlayerDaoTestAdd(){
        //dao test add
        Player toAdd = new Player(5, "六六","主攻",6);
        playerDao.addPlayer(toAdd);
        Assertions.assertEquals(6,playerDao.getPlayer(5).getNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void PlayerServiceTestGet(){
        //service test get
        Player test = playerService.getPlayer(4);
        Assertions.assertEquals(8,test.getNumber());
    }

    @Test
    @Transactional
    @Rollback
    public void PlayerServiceTestAdd(){
        //service test add
        //有重复
        Player toAdd1 = new Player(4,"段霁峰", "主攻",8);

        Assertions.assertEquals("id已存在", playerService.addPlayer(toAdd1));

        //无重复
        Player toAdd2 = new Player(7,"段霁峰", "主攻",8);

        Assertions.assertEquals("添加成功", playerService.addPlayer(toAdd2));
    }


}
