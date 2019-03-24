package ro.fiipractic.mycinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.mycinema.entities.MovieRoom;

public interface MovieRoomRepository extends JpaRepository<MovieRoom, Long> {
}
