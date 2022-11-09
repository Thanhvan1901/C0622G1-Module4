package codegym.repository.contract;

import codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
}
