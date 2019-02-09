package com.example.aditya.learnchess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvdescription;

    // Always declare a view before override of OncCreate and link with its id in the override of OnCreate

    String [] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvdescription = findViewById(R.id.tvdescription);
        descriptions = getResources().getStringArray(R.array.descriptions);


        // WHen in landscape mode, phone will null the potrail xml

        if(findViewById(R.id.layout_potrait)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment))
                    .hide(manager.findFragmentById(R.id.fragment2))
                    .commit();

        }


        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

                    manager.beginTransaction()
                            .show(manager.findFragmentById(R.id.fragment2))
                            .show(manager.findFragmentById(R.id.fragment))
                            .commit();
        }



    }

    @Override
    public void OnItemSelected(int index) {
        tvdescription.setText(descriptions[index]);

        if(findViewById(R.id.layout_potrait)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragment2))
                    .hide(manager.findFragmentById(R.id.fragment))

                    //enables back property
                    .addToBackStack(null)
                    .commit();

        }
    }
}
