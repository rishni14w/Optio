package com.example.rishni.optio.model;

public class Injury {
    private  Id _id;
    private String type;
    private String date;
    private String recovery;
    private String details;

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
