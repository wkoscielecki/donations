package pl.koscielecki.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koscielecki.app.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
