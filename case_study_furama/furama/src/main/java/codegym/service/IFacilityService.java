package codegym.service;

import codegym.model.facility.Facility;
import codegym.service.facility.FacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findBySearch(String name , String facilityType , Pageable pageable);
    Facility findById(int id);
    void save(Facility facility);
    void deleteId(int id);
    List<Facility> findAll();
}
