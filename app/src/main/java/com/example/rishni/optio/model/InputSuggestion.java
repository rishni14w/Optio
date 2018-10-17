package com.example.rishni.optio.model;

import java.util.List;

public class InputSuggestion {
    private String id;
    private String nic;
    private String input;
    private List suggestion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public List getSuggestion() {
        return suggestion;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }


    public String getSuggestion(int index)
    {
        return (String) suggestion.get(index);
    }

    public void setSuggestion(List suggestion) {
        this.suggestion = suggestion;
    }
}
