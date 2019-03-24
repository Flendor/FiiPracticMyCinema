package ro.fiipractic.mycinema.services;

import ro.fiipractic.mycinema.entities.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAll();

    Cinema getById(Long Id);

    Cinema saveCinema(Cinema cinemaForSave);

    List<Cinema> getCinemasByMovieRoomsCapacity(Integer capacity);
}
