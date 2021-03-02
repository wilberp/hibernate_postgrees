package com.chinock.store.api.repository;

import com.chinock.store.api.model.ArtistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistModel, Integer> {

    public Iterable<ArtistModel> findByNameStartsWith(String name);

}
