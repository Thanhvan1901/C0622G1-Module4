package codegym.repository.contract;

import codegym.dto.IContractDetailDto;
import codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConTractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select attach_facility.name as nameDto, " +
            "attach_facility.unit as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, " +
            "attach_facility.status as statusDto, attach_facility.cost as costDto " +
            "from contract_detail join attach_facility " +
            "on contract_detail.id = attach_facility.id " +
            "where contract_detail.id = :idFind group by attach_facility.id;", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);
}
