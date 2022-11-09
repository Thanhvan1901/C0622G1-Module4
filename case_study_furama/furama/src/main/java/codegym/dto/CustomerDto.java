package codegym.dto;

import codegym.model.contract.Contract;
import codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto implements Validator {

    private int id;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Phải viết hoa chữ cái của mỗi từ!")
    private String name;

    @NotBlank(message = "Không Được Để Trống")
    private String dateOfBirth;

    private boolean gender;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui Lòng Nhập Lại")
    private String idCard;

    @NotBlank(message = "Không Được Để Trống")
    @Pattern(regexp = "^(090|091|\\\\(84\\\\)\\\\+90|\\\\(84\\\\)\\\\+91)[0-9]{7}$",
            message = "Vui Lòng Nhập Lại")
    private String phoneNumber;

    @NotBlank(message = "Không Được Để Trống")
    @Email
    private String email;

    @NotBlank(message = "Không Được Để Trống")
    private String address;

    private boolean is_delete ;

    private CustomerType customerType;


    private List<Contract> contracts ;

    public CustomerDto() {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
