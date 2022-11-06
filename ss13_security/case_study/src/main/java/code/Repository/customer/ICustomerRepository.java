package codegym.Repository.customer;

import codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where name like %:namekeyword% " +
            "and email like %:emailKeyword% " +
            "and customer_type_id = :id and is_delete = 0 ;" , nativeQuery = true)
    Page<Customer> findBySearch(@Param("nameKeyword") String name ,
                               @Param("emailKeyword") String email ,
                               @Param("id") int id , Pageable pageable);

    @Query(value = "update customer set is_delete = 1 where id = :idKeyword ;" , nativeQuery = true)
    void delete(@Param("idKeyword") int id);
}
