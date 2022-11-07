package codegym.Repository.customer;

import codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
//    @Query(value = "select * from customer where name like %:name% and email like %:email%  and customer_type_id =:id and is_delete =:isDelete  ;" , nativeQuery = true)
//    Page<Customer> findBySearch(@Param("name") String name ,
//                               @Param("email") String email ,
//                               @Param("id") String id ,
//            @Param("isDelete") String isDelete, Pageable pageable);
    @Modifying
    @Query(value = "update customer set is_delete = 1 where id =:deleteId ", nativeQuery = true)
    void delete(@Param("deleteId") int deleteId);

    @Query(value = "select * from customer where customer.name like %:name% and customer.email like %:email% and customer.customer_type_id like %:customerType% and customer.is_delete =:isDelete", nativeQuery=true)
    Page<Customer> findBySearch(@Param("name") String name,
                                                       @Param("email") String email,
                                                       @Param("customerType") String customerType,
                                                       @Param("isDelete") String isDelete,
                                                       Pageable pageable);

//    @Query(value = "select * from customer where customer.is_delete =:isDelete " , nativeQuery = true)
//    Page<Customer> findBySearch(@Param("isDelete") String isDelete , Pageable pageable);
}
