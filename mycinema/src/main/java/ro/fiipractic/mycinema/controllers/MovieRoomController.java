package ro.fiipractic.mycinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.fiipractic.mycinema.entities.Cinema;
import ro.fiipractic.mycinema.entities.MovieRoom;
import ro.fiipractic.mycinema.services.CinemaService;
import ro.fiipractic.mycinema.services.MovieRoomService;

import java.util.List;

public class MovieRoomController {

    @Autowired
    MovieRoomService movieRoomService;

    @GetMapping
    public List<MovieRoom> getAllCinemas()
    {
        return movieRoomService.getAll();
    }

    @PostMapping
    public ResponseEntity<MovieRoom> saveMovieRoom()
    {
        return null;
    }
}
