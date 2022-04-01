package edu.ntnu.backend.repository;

import edu.ntnu.backend.model.User;
import edu.ntnu.backend.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO user (username, password) VALUES(?,?)",
                new Object[] { user.getUsername(), user.getPassword() });
    }

    @Override
    public User findUserByUsername(String username) {
        try {
            String SQL = "SELECT * FROM user WHERE username= '" + username + "'";
            User user = jdbcTemplate.queryForObject(SQL, new UserMapper());
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<User> getAllUsers() {
        String SQL = "select * from user";
        List <User> users = jdbcTemplate.query(SQL, new UserMapper());
        return users;
    }
}
