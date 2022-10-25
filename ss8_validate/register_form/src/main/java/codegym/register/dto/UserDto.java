package codegym.register.dto;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private int id;

    @NotNull
    @NotBlank(message = "Can't Be Blank")
    @Size(min = 5 , max = 45 , message = "Minimum length of 5, Maximum 45 character")
    private String lastName;

    @NotBlank(message = "Can't Be Blank")
    @Size(min = 5 , max = 45, message = "Minimum length of 5, Maximum 45 character")
    private String firstName;

    @NotBlank(message = "Can't Be Blank")
    @Min(18)
    private String age ;

    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    @Email
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target ;
        if ("admin".equals(userDto.getFirstName()) & "admin".equals(userDto.getLastName()) ){
            errors.rejectValue("name" ,"","Minimum length of 5, Maximum 45 character");
        }

    }
}
