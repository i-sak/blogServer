package com.project.blog.service;

import com.project.blog.dao.MenuRepository;
import com.project.blog.model.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // 조회 (개별)
    public MenuEntity getMenu(Long menuId) throws Exception{
        return menuRepository.findById(menuId).orElseThrow(()->
                new Exception());
    }


}
