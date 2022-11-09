package codegym.service;

import codegym.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
}
