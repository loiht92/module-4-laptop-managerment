package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends PagingAndSortingRepository<Laptop, Long> {
    Page<Laptop> findAllByStatus(Status status, Pageable pageable);

    Page<Laptop> findAllByName(String name, Pageable pageable);
}
