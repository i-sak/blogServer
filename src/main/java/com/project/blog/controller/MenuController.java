package com.project.blog.controller;

import com.project.blog.model.MenuEntity;
import com.project.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Select All Menu
    @GetMapping("")
    public List<MenuEntity> getAllMenu() {
        return menuService.getAllMenu();
    }
    // Select One Menu
    @GetMapping("/{menuId}")
    public Map<String, MenuEntity> getMenuByMenuId(@PathVariable Long menuId) throws Exception {
        MenuEntity me = menuService.getMenuById(menuId);
        Map<String, MenuEntity> map = new HashMap<>();
        map.put("menu",me);
        return map;
    }
    // Insert Menu added
    @PostMapping("")
    public MenuEntity registMenu(@RequestBody MenuEntity menuEntity) {
        return menuService.registMenu(menuEntity);
    }


}
