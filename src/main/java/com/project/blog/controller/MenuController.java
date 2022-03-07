package com.project.blog.controller;

import com.project.blog.model.MenuEntity;
import com.project.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{menuId}")
    public Map<String, MenuEntity> getMenuByMenuId(
            @PathVariable("menuId") Long menuId
    ) throws Exception {
        MenuEntity me = menuService.getMenu(menuId);
        Map<String, MenuEntity> map = new HashMap<>();
        map.put("menu",me);
        return map;
    }
}
