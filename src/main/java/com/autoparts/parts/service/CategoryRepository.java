package com.autoparts.parts.service;

import com.autoparts.parts.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository {

    void addCategory(CategoryEntity category);

    List<CategoryEntity> findAllCategories();
}
