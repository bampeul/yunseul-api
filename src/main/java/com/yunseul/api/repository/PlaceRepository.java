package com.yunseul.api.repository;

import com.yunseul.api.repository.entity.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    List<Place> findByType(String type);
}
