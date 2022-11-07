package codegym.repository.facility;

import codegym.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRenFacilityRepository extends JpaRepository<RentType, Integer> {
}
