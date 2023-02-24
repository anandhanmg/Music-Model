package MusicRespository;

import Entity.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Respository extends JpaRepository<MusicModel, Integer> {
}
