package com.example.t2009m1java.model.model;

import com.example.t2009m1java.entity.User;
import com.example.t2009m1java.model.InMemoryUserModel;
import com.example.t2009m1java.model.MySqlUserModel;
import com.example.t2009m1java.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MySqlUserModelTest {

    private UserModel model;

    @BeforeEach
    void setUp() {
        if (true) {
            model = new InMemoryUserModel();
        } else {
            model = new MySqlUserModel();
        }

        model.save(new User("xuanhong", "xyz", 1));
    }

    @Test
    void save() {
        User user = new User("xuanhong", "xyz", 1);
        assertEquals(true, model.save(user));
    }

    @Test
    void update() {
        List<User> users = model.findAll();
        // check có giá trị trong bảng
        assertNotEquals(0, users.size());
        if (users.size() > 0) {
            User user = users.get(0);
            user.setUsername("UpdatedUsername");
            // check việc update thành công
            assertEquals(true, model.update(user.getId(), user));
            // check việc thông tin đã được thay đổi
            User updated = model.findById(user.getId());
            assertEquals("UpdatedUsername", updated.getUsername());
        }
    }

    @Test
    void delete() {
        model.delete(1);
    }

    @Test
    void findAll() {
        assertNotEquals(0, model.findAll().size());
    }

    @Test
    void findById() {
        List<User> users = model.findAll();
        assertNotEquals(0, users.size());
        User user = users.get(0);
        User findByIdObject = model.findById(user.getId());
        assertNotEquals(null, findByIdObject);
        assertEquals(user.toString(), findByIdObject.toString());
    }
}