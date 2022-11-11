package codegym.dto;

import codegym.model.contract.Contract;
import codegym.model.facility.FacilityType;
import codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class FacilityDto implements Validator {

    private int id;

    @NotBlank(message = "Không Được Để Trống :)")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String name;

    @NotBlank(message = "Mày Bị Ngu à ")
    @Min(1)
    private String area;

    @NotBlank(message = "Không được để trống :))))))))))))")
    @Min(1)
    private String cost;

    @NotBlank(message = "Không được để trống")
    @Min(1)
    private String maxPeople;

    @NotBlank(message = "Không được để trống nhá ")
    private String standard;

    @NotBlank(message = "Không Được Để Trống")
    private String otherConvenience;

    @NotBlank(message = "Không được để trống")
    private String poolArea;

    @NotBlank(message = "Không được để trống")
    private String floors;

    private String facilityFree;

    private boolean is_delete;

    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToMany(mappedBy = "facilityId")
    private List<Contract> contracts;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    
    @Override
    public void validate(Object target, Errors errors) {

    }
}
