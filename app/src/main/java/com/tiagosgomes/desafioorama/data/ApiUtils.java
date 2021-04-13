package com.tiagosgomes.desafioorama.data;

public class ApiUtils {

    public static ApiService getInstance( )
    {
        return RetrofitClient.getInstance( ).create( ApiService.class );
    }
}
