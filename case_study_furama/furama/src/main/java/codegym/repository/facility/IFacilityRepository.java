package codegym.repository.facility;

import codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * from facility where name like %:name% and " +
            "facility_type_id like %:facilityType% and" +
            " is_delete = 0" , nativeQuery = true)
    Page<Facility> findBySearch(@Param("name") String name , @Param("facilityType") String facilityType , Pageable pageable);

    @Modifying
    @Query(value = "update facility set is_delete = 1 where id =:id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
