package codegym.service.contract;

import codegym.dto.IContractDto;
import codegym.model.contract.Contract;
import codegym.repository.contract.IContractRepository;
import codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return iContractRepository.findAllDto(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }


}
