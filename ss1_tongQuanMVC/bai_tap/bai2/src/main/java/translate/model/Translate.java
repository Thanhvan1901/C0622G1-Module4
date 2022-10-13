package translate.model;

public class Translate {
    private String english;
    private String vietNamese;

    public Translate() {
    }

    public Translate(String english, String vietNamese) {

        this.english = english;
        this.vietNamese = vietNamese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietNamese() {
        return vietNamese;
    }

    public void setVietNamese(String vietNamese) {
        this.vietNamese = vietNamese;
    }
}
