package com.yunseul.api.repository;

import com.yunseul.api.repository.entity.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {
}
