package com.project.blog.service;

import com.project.blog.dao.MenuRepository;
import com.project.blog.model.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // 조회 ( 1개 )
    public MenuEntity getMenuById(Long menuId) throws Exception{
        return menuRepository.findById(menuId).orElse(null);
    }
    // 전체 조회
    public List<MenuEntity> getAllMenu() {
        return menuRepository.findAll();
    }

    // 특정 레벨 계층의 메뉴 조회
    /*public List<MenuEntity> getMenuByLevel(int level) {

    }*/

    // 등록
    public MenuEntity registMenu(MenuEntity menuEntity) {
        return menuRepository.save(menuEntity);
    }

    // 수정
    public Optional<MenuEntity>  modifyMenu(Long menuId, MenuEntity menuEntity) {
        Optional<MenuEntity> menu = menuRepository.findById(menuId);
        menu.ifPresent(selectMenu -> {
            selectMenu.setName(menuEntity.getName());
            selectMenu.setParentMenuId(menuEntity.getParentMenuId());
            selectMenu.setLevel(menuEntity.getLevel());
            menuRepository.save(selectMenu);
        });
        return menu;
    }

    // 삭제
    public void removeMenu(long menuId) {
        Optional<MenuEntity> menu = menuRepository.findById(menuId);
        // 존재하는 경우 람다의 setter를 수행
        menu.ifPresent(selectMenu ->{
            menuRepository.delete(selectMenu);
        });
    }


}
