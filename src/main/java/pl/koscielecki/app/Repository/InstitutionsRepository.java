package pl.koscielecki.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koscielecki.app.model.TrustedInstitutions;
@Repository
public interface InstitutionsRepository extends JpaRepository<TrustedInstitutions, Long> {
}
