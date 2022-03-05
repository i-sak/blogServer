package com.project.blog.dao;

import com.project.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(100, "kim"));
        users.add(new User(200, "lee"));
        users.add(new User(300, "choi"));
        users.add(new User(400, "park"));
        users.add(new User(500, "kwon"));
        users.add(new User(600, "hong"));
        System.out.println(users);
    }

    public Map<String, String> getMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("greet","Hello world");
        return map;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUserByUserId(Integer userid) {
        return users.stream()
                .filter(x -> x.getUserid().equals(userid))
                .findFirst()    // 찾은 첫 번째 것
                .orElse(new User(0, "Not Available"));
    }

    public User registUser(User user) {
        users.add(user);
        return user;
    }

    public void modifyUser(User user) {
        users.stream()
                .filter(item->item.getUserid().equals(user.getUserid()))
                .findAny()
                .orElse(new User(0, "no user"))
                .setUsername(user.getUsername());
    }

    public void removeUser(Integer userid) {
        users.removeIf(user -> user.getUserid().equals(userid));
    }

}
