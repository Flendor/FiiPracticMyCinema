package ro.fiipractic.mycinema.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.mycinema.dtos.CinemaDto;
import ro.fiipractic.mycinema.entities.Cinema;
import ro.fiipractic.mycinema.services.CinemaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cinemas")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Cinema> getAllCinemas()
    {
        return cinemaService.getAll();
    }

    @PostMapping
    public ResponseEntity<Cinema> saveCinema(@RequestBody CinemaDto cinemaDto)
    {
        Cinema cinema = modelMapper.map(cinemaDto, Cinema.class);
        cinemaService.saveCinema(cinema);
        ResponseEntity c = null;
        try
        {
            c = ResponseEntity.created(new URI("/api/cinemas" + cinema.getId())).body(cinema);
        }
        catch(URISyntaxException e)
        {
            System.err.println(e.getMessage());
        }
        return c;
    }
}
