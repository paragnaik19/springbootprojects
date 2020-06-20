package com.parag.streams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parag.streams.model.Stream;


/**
 * 
 * @author parag
 *
 */
@Repository
public interface StreamRepository extends JpaRepository<Stream, Long> {}
