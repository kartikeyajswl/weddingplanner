package com.wedding.WeddingPlanner.repository;

import com.wedding.WeddingPlanner.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}