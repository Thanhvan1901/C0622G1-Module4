package codegym.service;

import codegym.dto.IContractDto;
import codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDto> findAllDto(Pageable pageable);
    void save(Contract contract);
}
