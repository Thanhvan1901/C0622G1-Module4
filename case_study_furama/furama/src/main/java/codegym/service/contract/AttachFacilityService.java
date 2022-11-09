package codegym.service.contract;

import codegym.model.contract.AttachFacility;
import codegym.repository.contract.IAttachFacilityRepository;
import codegym.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
