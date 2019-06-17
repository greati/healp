package com.example.healt_app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.healt_app.com.example.healt_app.models.FoodAddItem;
import com.example.healt_app.com.example.healt_app.surfaces.FoodCameraPreview;

import java.util.ArrayList;

public class RegisterFoodImageActivity extends AppCompatActivity {

    private Camera mCamera;
    private FoodCameraPreview mPreview;

    private Button btManual;
    private ImageButton btCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_food_image);

        setTitle("Registrar alimentação");

        mCamera = getCameraInstance();
        mPreview = new FoodCameraPreview(this, mCamera);
        FrameLayout preview = findViewById(R.id.fl_food_camera_preview);
        preview.addView(mPreview);
        mCamera.setDisplayOrientation(90);

        btCapture = findViewById(R.id.bt_capture_food_image);
        btManual = findViewById(R.id.bt_manual_food);

        btCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<FoodAddItem> itemsIntent = new ArrayList<FoodAddItem>();

                itemsIntent.add(new FoodAddItem("Batata Frita", 239.0));
                itemsIntent.add(new FoodAddItem("Arroz", 300.0));
                itemsIntent.add(new FoodAddItem("Feijão", 350.0));
                itemsIntent.add(new FoodAddItem("Carne", 100.0));

                Intent i = new Intent(v.getContext(), RegisterFoodActivity.class);

                i.putExtra("items", itemsIntent);

                startActivity(i);
            }
        });

        btManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), RegisterFoodActivity.class);

                i.putExtra("items", new ArrayList<FoodAddItem>());

                startActivity(i);
            }
        });

    }



    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }


}
