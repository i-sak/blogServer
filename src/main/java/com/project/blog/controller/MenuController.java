package com.project.blog.controller;

import com.project.blog.model.MenuEntity;
import com.project.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
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
    // Get Menu By Level
    @GetMapping("/level/{level}")
    public List<MenuEntity> getMenuByLevel(@PathVariable int level) {
        return menuService.getMenuByLevel(level);
    }

    // Insert Menu added
    @PostMapping("")
    public MenuEntity registMenu(@RequestBody MenuEntity menuEntity) {
        return menuService.registMenu(menuEntity);
    }

    // Update Menu
    @PutMapping("/{menuId}")
    public Optional<MenuEntity> modifyMenu(@PathVariable Long menuId, @RequestBody MenuEntity menuEntity) {
        return menuService.modifyMenu(menuId, menuEntity);
    }
    // Delete Menu
    @DeleteMapping("/{menuId}")
    public void removeMenu(@PathVariable("menuId") long menuId) {
        menuService.removeMenu(menuId);
    }

}
