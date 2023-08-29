package com.myflashlightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    TextView textView;
    CameraManager cameraManager;
    String cameraid ,output;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.Switch_on_off);
        textView = findViewById(R.id.off);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                torch(isChecked);
            }
        });


    }

    private void torch(boolean isChecked) {

        try{
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            cameraid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,isChecked);
            output = isChecked? "ON":"OFF";
            textView.setText(output);

        }catch (CameraAccessException e){
            e.printStackTrace();
        }

    }

    private class cameraManager {
    }
}