package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Laptop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends PagingAndSortingRepository<Laptop, Long> {
}
