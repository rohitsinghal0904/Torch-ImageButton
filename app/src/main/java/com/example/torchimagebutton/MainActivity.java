package com.example.torchimagebutton;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton i1;
    CameraManager cm;
    private boolean torch=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=(ImageButton)findViewById(R.id.imageButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (torch == false) {
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,true);
                        i1.setImageResource(R.drawable.g);
                        torch=true;

                    }else{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                        i1.setImageResource(R.drawable.r);
                        torch=false;
                    }
                }catch (CameraAccessException e){

                }

            }
        });
    }
}