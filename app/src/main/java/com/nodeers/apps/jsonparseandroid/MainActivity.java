package com.nodeers.apps.jsonparseandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    OurRetrofitClient ourRetrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

     Call<SpecipicObjectData> call=   ourRetrofitClient.getData(2,"LB2NyDXhCctejZCWEpe4vSpNwe2oh7HFwynJ7naEiKXu7XcxChuKoAkLoksj");


     /////object data
     call.enqueue(new Callback<SpecipicObjectData>() {
         @Override
         public void onResponse(Call<SpecipicObjectData> call, Response<SpecipicObjectData> response) {

             if(response.isSuccessful()){

               ObjectDataClass objectDataClass=  response.body().getData();

               Log.d("name",objectDataClass.getName());
               Log.d("id", String.valueOf(objectDataClass.getId()));
               Log.d("resource",objectDataClass.getResource());
               Log.d("updated_at",objectDataClass.getUpdated_at());

             }else {
                 Log.d("response","fail");
             }
         }

         @Override
         public void onFailure(Call<SpecipicObjectData> call, Throwable t) {

         }
     });

     ///list of Data

    /* call.enqueue(new Callback<OurMainDataClass>() {
         @Override
         public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {

             if(response.isSuccessful()){

              List<ObjectDataClass> list=   response.body().getData();
              for(ObjectDataClass objectDataClass: list){

                  Log.d("id", String.valueOf(objectDataClass.getId()));
                  Log.d("name", String.valueOf(objectDataClass.getName()));
                  Log.d("resource", String.valueOf(objectDataClass.getResource()));
                  Log.d("updated_at", String.valueOf(objectDataClass.getUpdated_at()));
              }
             }else {
                 Log.d("response","fail");
             }
         }

         @Override
         public void onFailure(Call<OurMainDataClass> call, Throwable t) {

             Log.d("response","fail");
         }
     });*/

    }

}