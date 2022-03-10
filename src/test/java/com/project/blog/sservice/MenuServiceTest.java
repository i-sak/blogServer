package com.project.blog.sservice;

import com.project.blog.dao.MenuRepository;
import com.project.blog.model.MenuEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuRepository menuRepository;

    //@Test
    public void update() {
        Optional<MenuEntity> menu = menuRepository.findById(2L);
        // 존재하는 경우 람다의 setter를 수행
        menu.ifPresent(selectMenu ->{
            selectMenu.setName("Category");
            menuRepository.save(selectMenu);
        });
    }

    //@Test
    public void delete() {
        Optional<MenuEntity> menu = menuRepository.findById(2L);
        // 존재하는 경우 람다의 setter를 수행
        menu.ifPresent(selectMenu ->{
            menuRepository.delete(selectMenu);
        });
    }

    //@Test
    public void selectAll() {
        menuRepository.findAll().forEach(menuEntity -> {
            System.out.println(menuEntity.toString());
        });
    }

    // 특정한 값들 불러오기
    @Test
    public  void selectByLevel() {
        menuRepository.findByLevel(1).forEach(menuEntity -> {
            System.out.println(menuEntity);
        });
    }


}
