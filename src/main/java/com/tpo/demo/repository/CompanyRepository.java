package com.tpo.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import com.tpo.demo.model.CompanyEntity;

import reactor.core.publisher.Mono;

public interface CompanyRepository extends ReactiveNeo4jRepository<CompanyEntity, String> {
    Mono<CompanyEntity> findOneByName(String name);  // Cambiar "findOneByTitle" a "findOneByName"
}