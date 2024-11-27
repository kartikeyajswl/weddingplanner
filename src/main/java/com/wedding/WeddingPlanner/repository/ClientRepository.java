package com.wedding.WeddingPlanner.repository;

import com.wedding.WeddingPlanner.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByWeddingDate(String weddingDate);

    @Query("SELECT c FROM Client c WHERE c.budget BETWEEN :minBudgetRange AND :maxBudgetRange")
    List<Client> findByBudgetRange(@Param("minBudgetRange") double minBudgetRange, @Param("maxBudgetRange") double maxBudgetRange);
}