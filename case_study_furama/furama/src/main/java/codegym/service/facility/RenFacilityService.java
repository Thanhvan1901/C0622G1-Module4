package codegym.service.facility;

import codegym.model.facility.RentType;
import codegym.repository.facility.IRenFacilityRepository;
import codegym.service.IRentFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RenFacilityService implements IRentFacilityService {

    @Autowired
    private IRenFacilityRepository iRenFacilityRepository;
    @Override
    public List<RentType> findAll() {
        return iRenFacilityRepository.findAll();
    }
}
