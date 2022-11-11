package codegym.service.facility;

import codegym.model.facility.Facility;
import codegym.repository.facility.IFacilityRepository;
import codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findBySearch(String name, String facilityType, Pageable pageable) {
        return iFacilityRepository.findBySearch(name,facilityType,pageable);
    }

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id).get();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void deleteId(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
}
