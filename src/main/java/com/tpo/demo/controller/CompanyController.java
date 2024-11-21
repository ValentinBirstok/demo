package com.tpo.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.tpo.demo.model.CompanyEntity;
import com.tpo.demo.repository.CompanyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/companies")  // Cambiar "/movies" a "/companies"
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PutMapping
    Mono<CompanyEntity> createOrUpdateCompany(@RequestBody CompanyEntity newCompany) {  // Cambiar "createOrUpdateMovie" a "createOrUpdateCompany"
        return companyRepository.save(newCompany);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<CompanyEntity> getCompanies() {  // Cambiar "getMovies" a "getCompanies"
        return companyRepository.findAll();
    }
}