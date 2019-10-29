package com.cyxtera.fabianmondragon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyxtera.fabianmondragon.myapplication.conexion.ControllerAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControllerAPI controller = new ControllerAPI();
        controller.start();
    }
}
