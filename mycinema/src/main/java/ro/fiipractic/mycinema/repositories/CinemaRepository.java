package ro.fiipractic.mycinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fiipractic.mycinema.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
