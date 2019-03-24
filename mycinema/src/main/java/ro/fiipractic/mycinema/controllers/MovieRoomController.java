package ro.fiipractic.mycinema.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.mycinema.dtos.MovieRoomDto;
import ro.fiipractic.mycinema.entities.MovieRoom;
import ro.fiipractic.mycinema.services.MovieRoomService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/movie-room")
public class MovieRoomController {

    @Autowired
    MovieRoomService movieRoomService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<MovieRoom> getAllCinemas()
    {
        return movieRoomService.getAll();
    }

    @PostMapping
    public ResponseEntity<MovieRoom> saveMovieRoom(@RequestBody MovieRoomDto movieRoomDto) throws URISyntaxException
    {
        MovieRoom movieRoom = modelMapper.map(movieRoomDto, MovieRoom.class);
        movieRoomService.saveMovieRoom(movieRoom);
        return ResponseEntity.created(new URI("/api/movie-rooms/" + movieRoom.getId())).body(movieRoom);
    }

    @GetMapping(value = "/filter/{cinemaId}")
    public List<MovieRoom> getAllMovieRoomsByCinema_Id(@PathVariable Long cinemaId)
    {
        return movieRoomService.getAllMovieRoomsByCinema_Id(cinemaId);
    }
}
