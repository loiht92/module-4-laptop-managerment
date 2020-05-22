package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Origin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends PagingAndSortingRepository<Origin, Long> {
}
