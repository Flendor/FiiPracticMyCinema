package ro.fiipractic.mycinema.services;

import org.springframework.stereotype.Service;
import ro.fiipractic.mycinema.entities.Cinema;
import ro.fiipractic.mycinema.entities.MovieRoom;

import java.util.List;


public interface MovieRoomService {
    List<MovieRoom> getAll();

    MovieRoom saveMovieRoom(MovieRoom movieRoomForSave);
}
