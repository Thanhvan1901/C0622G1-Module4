package codegym.service.contract;

import codegym.dto.IContractDetailDto;
import codegym.model.contract.ContractDetail;
import codegym.repository.contract.IConTractDetailRepository;
import codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IConTractDetailRepository iConTractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return iConTractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iConTractDetailRepository.save(contractDetail);
    }

    @Override
    public List<IContractDetailDto> showAll(Integer id) {
        return iConTractDetailRepository.showAll(id);
    }
}
