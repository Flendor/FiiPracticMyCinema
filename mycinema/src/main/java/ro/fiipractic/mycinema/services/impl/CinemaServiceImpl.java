package ro.fiipractic.mycinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fiipractic.mycinema.entities.Cinema;
import ro.fiipractic.mycinema.repositories.CinemaRepository;
import ro.fiipractic.mycinema.services.CinemaService;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema saveCinema(Cinema cinemaForSave) {
        return cinemaRepository.save(cinemaForSave);
    }

    @Override
    public Cinema getById(Long Id) {
        return cinemaRepository.findById(Id).orElseThrow(() -> new RuntimeException("Non-existent ID!"));
    }

    @Override
    public List<Cinema> getCinemasByMovieRoomsCapacity(Integer capacity) {
        return cinemaRepository.getCinemasByMovieRoomsCapacity(capacity);
    }
}
