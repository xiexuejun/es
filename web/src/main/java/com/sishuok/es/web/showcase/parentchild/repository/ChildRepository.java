/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.es.web.showcase.parentchild.repository;

import com.sishuok.es.common.repository.BaseRepository;
import com.sishuok.es.web.showcase.parentchild.entity.Child;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface ChildRepository extends BaseRepository<Child, Long> {

    @Query(value = "from Child where parent.id=?1")
    Page<Child> findByParent(Long parentId, Pageable pageable);

    @Modifying
    @Query(value = "delete from Child where id in (?1)")
    void deleteByIds(List<Long> ids);
}