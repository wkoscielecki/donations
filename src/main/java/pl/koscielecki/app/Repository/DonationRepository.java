package pl.koscielecki.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koscielecki.app.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
