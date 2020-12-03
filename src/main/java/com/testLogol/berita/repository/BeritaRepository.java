package com.testLogol.berita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testLogol.berita.model.Berita;

@Repository
public interface BeritaRepository extends JpaRepository<Berita, String>{

}
