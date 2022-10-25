package codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id ;

    @NotNull
    @NotBlank (message = "Không Được Để Trống")
    @Size(max = 8000 , message = "Không Được quá 800 Kí Tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "trường này không chứa kí tự đặt biệt và dấu tiếng việt")
    private String nameSong ;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 300,message = "Trường này không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "trường này không chứa kí tự đặt biệt và dấu tiếng việt")
    private String singer ;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 1000,message = "Trường này không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$",message = "Trường này ngoại trừ dấu phẩy thì kí tự dặt biệt không nhận")
    private String category ;

    public SongDto() {
    }

    public SongDto(int id, String nameSong, String singer, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
