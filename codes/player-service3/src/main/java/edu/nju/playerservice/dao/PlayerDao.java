package edu.nju.playerservice.dao;


import edu.nju.playerservice.model.Player;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PlayerDao {

    void addPlayer(Player player);

    Player getPlayer(int id);


}
