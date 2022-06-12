package com.nmutistr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nmutistr.model.Arrays;

/**
 * Clase Repository
 * @author nicolas
 *
 */
@Repository
public interface IArraysRepo extends JpaRepository<Arrays, Integer> {

}
