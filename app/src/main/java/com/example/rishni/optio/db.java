package com.example.rishni.optio;

import com.example.rishni.optio.model.Injury;


public class db {
    private  static String DB_NAME="optio";
    private static String COLLECTION_NAME_BODYCOMPOSITION="bodycomposition";
    private static String COLLECTION_NAME_INJURY="injury";
    private static String COLLECTION_NAME_VACCINATION="vaccination";
    private static String COLLECTION_NAME_SLEEP="sleep";
    private static String COLLECTION_NAME_HEARTRATE="heartrate";

    public static String API_KEY="CoT0fJmLYRgJtCu2DpPG25PzvQVCtDks";

    //injury
    public static String getAddressSingle_Injury(String oid)
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_INJURY);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("/"+oid+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    public static String getAddressAPI_Injury()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_INJURY);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }


    //vaccination
    public static String getAddressSingle_Vaccination(String oid)
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_VACCINATION);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("/"+oid+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    public static String getAddressAPI_Vaccination()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_VACCINATION);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    //Sleep
    public static String getAddressAPI_Sleep()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_SLEEP);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    //Heartrate
    public static String getAddressAPI_Heartrate()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_HEARTRATE);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    //bodycomposition
    public static String getAddressAPI_BodyComposition()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_BODYCOMPOSITION);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }
}
