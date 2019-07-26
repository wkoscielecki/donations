package pl.koscielecki.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.koscielecki.app.model.Items;


@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
}
