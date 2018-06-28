package com.example.rishni.optio;

public class Validation {
    public boolean isEmpty(String value1,String value2,String value3)
    {
        if((value1.isEmpty())||(value2.isEmpty())||(value3.isEmpty()))
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty(String value1,String value2)
    {
        if((value1.isEmpty())||(value2.isEmpty()))
        {
            return true;
        }
        return false;
    }
}
