package com.example.lastproject.repository;

import com.example.lastproject.domain.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    List<Credit> findAll();

}
