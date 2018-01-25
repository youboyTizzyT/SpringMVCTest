package com.example.dao;

import com.example.model.AbstractPlayer;
import com.example.model.SangongUser.SangongPlayer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PlayerDaoImp implements PlayerDao {

    private DataSource datasource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.datasource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
    }

    /**
     * 向数据库中添加一个玩家
     * @param player
     */
    @Override
    public void addPlayer(AbstractPlayer player) {
        String sql = "INSERT INTO myweb.useridpw(uid,password)VALUES(?,?)";
        String sql_1="INSERT INTO myweb.userinfo(uid,name,sex,age,location)VALUES (?,?,?,?,?)";
        jdbcTemplateObject.update(sql, player.getUserId(),player.getPasswd());
        jdbcTemplateObject.update(sql_1, player.getUserId(),player.getUserName(),player.getSex(),player.getAge(),player.getLocation());
    }

    @Override
    public void delPlayerByUID(Integer uid) {
        String sql = "DELETE FROM myweb.useridpw WHERE uid=?";
        String sql1 = "DELETE FROM myweb.userinfo WHERE uid=?";
        jdbcTemplateObject.update(sql,uid);
        jdbcTemplateObject.update(sql1,uid);

    }

    @Override
    public void delallstudent() {
        String sql = "DELETE FROM myweb.userinfo";
        String sql1 = "DELETE FROM myweb.useridpw";
        jdbcTemplateObject.update(sql);
        jdbcTemplateObject.update(sql1);

    }

    @Override
    public void updstudent(AbstractPlayer student) {
        String sql = "UPDATE myweb.userinfo set sex=?,age=?,location=?,name=? WHERE uid=?";
        String sql1 = "UPDATE myweb.useridpw set password=? WHERE uid=?";
        jdbcTemplateObject.update(sql,student.getSex(), student.getAge(),student.getLocation(),student.getUserName(),student.getUserId());
        jdbcTemplateObject.update(sql1,student.getPasswd(),student.getUserId());

    }

    @Override
    public List<SangongPlayer> allPlayer() {
        List<SangongPlayer> students = null;
        String sql = "SELECT  a.uid,a.password,b.name,b.location,b.sex,b.age FROM myweb.useridpw as a LEFT JOIN myweb.userinfo AS b ON a.uid=b.uid";
        students = jdbcTemplateObject.query(sql,  new StudentMapper());
        return students;
    }

    @Override
    public List<SangongPlayer> queryPlayerByUID(Integer uid) {
        List<SangongPlayer> students=null;
        String sql = "SELECT  a.uid,a.password,b.name,b.location,b.sex,b.age FROM myweb.useridpw as a LEFT JOIN myweb.userinfo AS b ON a.uid=b.uid Where a.uid="+uid;
        students=jdbcTemplateObject.query(sql,new StudentMapper());
        return students;
    }

    public static void main(String[] args) {

    }


}
