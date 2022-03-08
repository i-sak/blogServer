package com.project.blog.service;

import com.project.blog.dao.MenuRepository;
import com.project.blog.model.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // 조회 ( 1개 )
    public MenuEntity getMenuById(Long menuId) throws Exception{
        return menuRepository.findById(menuId).orElse(null);
    }

    public List<MenuEntity> getAllMenu() {
        return menuRepository.findAll();
    }

    public MenuEntity registMenu(MenuEntity menuEntity) {
        return menuRepository.save(menuEntity);
    }
}
