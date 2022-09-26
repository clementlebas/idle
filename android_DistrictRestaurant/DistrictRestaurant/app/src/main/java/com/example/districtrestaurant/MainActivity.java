package com.example.districtrestaurant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        TextView sho;
        //showLog = (TextView) findViewById (R.id.showLog);
        //showLog.setText("Bonjour " + user + ", votre mot de passe est " + pwd);



        List<District> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                District arr = (District) o;
                Toast.makeText(MainActivity.this, "Selected :"
                        + " " + arr, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(), RestaurantActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("arr", arr.getNumero());

                Intent intentLogin = getIntent();
                Bundle bundleLogin = intentLogin.getExtras();
                String user = bundleLogin.getString("user");
                bundle.putString("user", user);
                Log.v("user", user);
                String pwd = bundleLogin.getString("pwd");


                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private  List<District> getListData() {
        List<District> list = new ArrayList<District>();
        District dis1 = new District("Louvre", "img_district1", 1);
        District dis2 = new District("Bourse", "img_district2", 2);
        District dis3 = new District("Temple", "img_district3", 3);
        District dis4 = new District("Hotel de ville", "img_district4", 4);
        District dis5 = new District("Pantheon", "img_district5", 5);
        District dis6 = new District("Luxembourg", "img_district6", 6);
        District dis7 = new District("Palais Bourbon", "img_district7", 7);
        District dis8 = new District("Elysee", "img_district8", 8);
        District dis9 = new District("Opéra", "img_district9", 9);
        District dis10 = new District("Enclos", "img_district10", 10);
        District dis11 = new District("Bastille", "img_district11", 11);
        District dis12 = new District("Reuilly", "img_district12", 12);
        District dis13 = new District("Gobelins", "img_district13", 13);
        District dis14 = new District("Observatoire", "img_district14", 14);
        District dis15 = new District("Vaugirard", "img_district15", 15);
        District dis16 = new District("Passy", "img_district16", 16);
        District dis17 = new District("Batignolles", "img_district17", 17);
        District dis18 = new District("Montmartre", "img_district18", 18);
        District dis19 = new District("Chaumont", "img_district19", 19);
        District dis20 = new District("Ménilmontant", "img_district20", 20);

        list.add(dis1);
        list.add(dis2);
        list.add(dis3);
        list.add(dis4);
        list.add(dis5);
        list.add(dis6);
        list.add(dis7);
        list.add(dis8);
        list.add(dis9);
        list.add(dis10);
        list.add(dis11);
        list.add(dis12);
        list.add(dis13);
        list.add(dis14);
        list.add(dis15);
        list.add(dis16);
        list.add(dis17);
        list.add(dis18);
        list.add(dis19);
        list.add(dis20);


        return list;
    }



}