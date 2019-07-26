package pl.koscielecki.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koscielecki.app.model.City;
@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
