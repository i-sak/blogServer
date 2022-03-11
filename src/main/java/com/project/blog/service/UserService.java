package com.project.blog.service;

import com.project.blog.dao.UserRepository;
import com.project.blog.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    // getUserById
    public Map<String, UserEntity> getUserById(Long userId) {
        UserEntity userEntity = usersRepository.findById(userId).orElse(null);
        Map<String, UserEntity> map = new HashMap<>();
        map.put("user", userEntity);
        return map;
    }

    // selectAll User
    public List<UserEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    // select User by Role
    public List<UserEntity> getUserByRole(String role) {
        return usersRepository.findByRole(role);
    }

    // insert User
    public UserEntity registUser(UserEntity userEntity) {
        return usersRepository.save(userEntity);
    }

    // update User : 유저 정보 수정(update)
    public Optional<UserEntity> modifyUser(Long userId, UserEntity userEntity) {
        Optional<UserEntity> user = usersRepository.findById(userId);
        user.ifPresent(selectUser -> {
            selectUser.setName(userEntity.getName());
            selectUser.setEmail(userEntity.getEmail());
            selectUser.setPassword(userEntity.getPassword());
            selectUser.setRole(userEntity.getRole());
            usersRepository.save(selectUser);
        });
        return user;
    }
    // delete User
    public void deleteUser(long userId) {
        Optional<UserEntity> user = usersRepository.findById(userId);
        user.ifPresent(selectUser -> {
            usersRepository.delete(selectUser);
        });
        //usersRepository.deleteById(userId);
    }

}
