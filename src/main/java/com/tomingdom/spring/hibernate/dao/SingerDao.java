package com.tomingdom.spring.hibernate.dao;

import com.tomingdom.spring.hibernate.entities.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer contact);

    void delete(Singer contact);
}
