package com.example.dao;


import com.example.model.AbstractPlayer;
import com.example.model.SangongUser.SangongPlayer;

import javax.sql.DataSource;
import java.util.List;

public interface PlayerDao {
    public void setDataSource(DataSource ds);

    public void addPlayer(AbstractPlayer player);

    public void delPlayerByUID(Integer uid);

    public void delallstudent();

    public void updstudent(AbstractPlayer student);

    public List<SangongPlayer> allPlayer();

    public List<SangongPlayer> queryPlayerByUID(Integer Uid);

}
