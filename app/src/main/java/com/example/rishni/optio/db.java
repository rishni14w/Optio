package com.example.rishni.optio;

public class db {
    private  static String DB_NAME="optio";

    private static String COLLECTION_NAME_ILLNESSINJURY="illnessinjury";
    private static String COLLECTION_NAME_PERSONAL="personal";
    private static String COLLECTION_NAME_PRECOMPETITION="precompetition";

    public static String API_KEY="CoT0fJmLYRgJtCu2DpPG25PzvQVCtDks";


    //illness and injury
    public static String getAddressAPI_IllnessInjury()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_ILLNESSINJURY);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    //personal
    public static String getAddressAPI_Personal()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_PERSONAL);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }


    //pre competition
    public static String getAddressAPI_PreCompetition()
    {
        String baseUrl=String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME_PRECOMPETITION);
        StringBuilder stringBuilder=new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }
}
