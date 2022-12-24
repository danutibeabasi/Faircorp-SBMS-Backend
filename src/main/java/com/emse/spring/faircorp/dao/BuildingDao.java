package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents a data access object for buildings.
 * This interface extends the JpaRepository interface and provides basic CRUD operations for buildings.
 */
public interface BuildingDao extends JpaRepository<Building, Long> {
}


