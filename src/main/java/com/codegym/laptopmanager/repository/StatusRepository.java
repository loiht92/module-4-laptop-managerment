package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Status;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends PagingAndSortingRepository<Status, Long> {
}
