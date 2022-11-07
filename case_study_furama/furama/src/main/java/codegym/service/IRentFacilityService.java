package codegym.service;

import codegym.model.facility.RentType;

import java.util.List;

public interface IRentFacilityService {
    List<RentType> findAll();
}
