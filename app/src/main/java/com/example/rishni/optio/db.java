package com.example.rishni.optio;

import com.example.rishni.optio.model.Injury;


public class db {
    private  static String DB_NAME="optio";
    private static String COLLECTION_NAME="user";
    private static String COLLECTION_NAME_INJURY="injury";
    private static String COLLECTION_NAME_VACCINATION="vaccination";

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
}
