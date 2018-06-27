package com.example.rishni.optio.model;

public class IllnessInjury {
    private  Id _id;
    private String sick;
    private String injured;
    private String injuredAgain;
    private String partner_in_pain;
    private String partner_injury;
    private String nightmare;
    private String flashback;

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public String getInjured() {
        return injured;
    }

    public void setInjured(String injured) {
        this.injured = injured;
    }

    public String getInjuredAgain() {
        return injuredAgain;
    }

    public void setInjuredAgain(String injuredAgain) {
        this.injuredAgain = injuredAgain;
    }

    public String getPartner_in_pain() {
        return partner_in_pain;
    }

    public void setPartner_in_pain(String partner_in_pain) {
        this.partner_in_pain = partner_in_pain;
    }

    public String getPartner_injury() {
        return partner_injury;
    }

    public void setPartner_injury(String partner_injury) {
        this.partner_injury = partner_injury;
    }

    public String getNightmare() {
        return nightmare;
    }

    public void setNightmare(String nightmare) {
        this.nightmare = nightmare;
    }

    public String getFlashback() {
        return flashback;
    }

    public void setFlashback(String flashback) {
        this.flashback = flashback;
    }
}
