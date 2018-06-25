package com.example.rishni.optio.model;

public class Sleep {
    private  Id _id;
    private String sleepDuration;

    public Id get_id() {
        return _id;
    }

    public void set_id(Id _id) {
        this._id = _id;
    }

    public String getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(String sleepDuration) {
        this.sleepDuration = sleepDuration;
    }
}
