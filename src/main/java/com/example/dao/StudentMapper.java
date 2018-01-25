package com.example.dao;

import com.example.model.SangongUser.SangongPlayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 */
public class StudentMapper implements RowMapper<SangongPlayer> {
    @Override
    public SangongPlayer mapRow(ResultSet rs, int rownum) throws SQLException {
        SangongPlayer student = new SangongPlayer();
        student.setPasswd(rs.getInt("password"));
        student.setUserId(rs.getInt("uid"));
        student.setAge(rs.getInt("age"));
        student.setLocation(rs.getString("location"));
        student.setUserName(rs.getString("name"));
        student.setSex(rs.getInt("sex"));
        return student;
    }
}
