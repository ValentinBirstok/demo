package com.tpo.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.tpo.demo.model.MovieEntity;
import com.tpo.demo.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    //method implementations with walkthroughs below

    @PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }



}
