package codegym.repository.facility;

import codegym.model.customer.Customer;
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

    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id " +
            "where f.name like %:name% and " +
            "ft.name like %:facilityType% and" +
            " is_delete = 0" , nativeQuery = true)
    Page<Facility> findBySearch(@Param("name") String name , @Param("facilityType") String facilityType , Pageable pageable);

//    @Query(value = "select c.* from `customer` c  join `customer_type` ct on c.customer_type_id = ct.id " +
//            "where c.name like %:name% and c.email like %:email% and ct.name like %:customerType% and c.is_delete =0", nativeQuery=true)
//    Page<Customer> findBySearch(@Param("name") String name,
//                                @Param("email") String email,
//                                @Param("customerType") String customerType,
//                                Pageable pageable);
    @Modifying
    @Query(value = "update facility set is_delete = 1 where id =:id", nativeQuery = true)
    void deleteById(@Param("id") int id);
}
