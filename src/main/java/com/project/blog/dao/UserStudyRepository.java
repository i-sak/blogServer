package com.project.blog.dao;

import com.project.blog.model.UserStudy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserStudyRepository {

    public static List<UserStudy> users;

    static {
        users = new ArrayList<>();
        users.add(new UserStudy(100, "kim"));
        users.add(new UserStudy(200, "lee"));
        users.add(new UserStudy(300, "choi"));
        users.add(new UserStudy(400, "park"));
        users.add(new UserStudy(500, "kwon"));
        users.add(new UserStudy(600, "hong"));
        //System.out.println(users);
    }

    public Map<String, String> getMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("greet","Hello world");
        return map;
    }

    public List<UserStudy> getUsers() {
        return this.users;
    }

    public UserStudy getUserByUserId(Integer userid) {
        return users.stream()
                .filter(x -> x.getUserid().equals(userid))
                .findFirst()    // 찾은 첫 번째 것
                .orElse(new UserStudy(0, "Not Available"));
    }

    public UserStudy registUser(UserStudy user) {
        users.add(user);
        return user;
    }

    public void modifyUser(UserStudy user) {
        users.stream()
                .filter(item->item.getUserid().equals(user.getUserid()))
                .findAny()
                .orElse(new UserStudy(0, "no user"))
                .setUsername(user.getUsername());
    }

    public void removeUser(Integer userid) {
        users.removeIf(user -> user.getUserid().equals(userid));
    }

}
