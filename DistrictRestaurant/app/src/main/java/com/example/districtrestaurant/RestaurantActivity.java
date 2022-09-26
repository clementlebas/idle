package com.example.districtrestaurant;

import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int selectedArr = bundle.getInt("arr");
        Log.v("selectedArr", String.valueOf(selectedArr));
        String user = bundle.getString("user");

        getDistrict(selectedArr);



        TextView showArr;
        showArr = (TextView) findViewById (R.id.selectedArr);
        showArr.setText("Arrondissement selectionné " + selectedArr + " par le user : " + user);



        String[] restauArray = {"Les frères tacos","Georges V","Ritz"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, restauArray);

        /*
        ListView listView = (ListView) findViewById(R.id.restau_list);
        listView.setAdapter(adapter);

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });*/
    }

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
            }

    public void getDistrict(int arr){

        String urlString = "http://localhost/DistrictRestaurant/DistrictRestanrant.php?district="+arr;

            pDialog.setMessage("Getting list of Retaurants...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        Log.v("GetHere", "Where the hoods at ?");

        Ion.with(this)
                .load(urlString)//URL
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e, Response<String> result) {
                        {
                            Log.v("Here", "OverHere");
                            pDialog.dismiss();
                            Log.v("plup", "Meow");
                            Log.v("res",result.getResult());
                            if (result == null) {
                                Log.v("No response", result.getResult());
                                Log.v("inIf", "gotNoResult");
                            }
                            else {
                                TextView resultView;
                                resultView = (TextView) findViewById (R.id.result);
                                resultView.setText("Result " + result.getResult());
                                Log.v("Response ok", result.getResult());
                                Log.v("outIf", "GotSome");
                            }
                        }
                    }

                    /*@Override
                    public void onCompleted(Exception e, String result) {
                        Log.v("Here", "OverHere");
                        pDialog.dismiss();
                        Log.v("plup", "Meow");
                        Log.v("res",result);
                        if (e == null) {
                            Log.v("No response", result);
                            Log.v("inIf", "gotNoResult");
                        }
                        else {
                            TextView resultView;
                            resultView = (TextView) findViewById (R.id.result);
                            resultView.setText("Result " + result);
                            Log.v("Response ok", result);
                            Log.v("outIf", "GotSome");
                        }
                */});
    }
}
