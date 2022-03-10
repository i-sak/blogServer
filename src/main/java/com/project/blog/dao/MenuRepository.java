package com.project.blog.dao;

import com.project.blog.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    List<MenuEntity> findByLevel(int level);
}
