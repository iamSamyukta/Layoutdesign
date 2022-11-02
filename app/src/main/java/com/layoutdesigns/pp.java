package com.layoutdesigns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class pp extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ImageView popup, imageViewprofilepicture;
    private Dialog dialog;
    private Button google1,facebook1,save;
//    TextView text1;
    Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pp);

        google1=findViewById(R.id.google1);
        facebook1=findViewById(R.id.facebook1);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.brown1)));
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().show();

        imageViewprofilepicture = findViewById(R.id.imageViewprofilepicture);

        imageViewprofilepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomsheet bottomSheetFragment = new bottomsheet();
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());

            }
        });

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pp.this,Profile.class);
                startActivity(intent);
            }
        });

//        text1  = findViewById(R.id.text1);
//        text1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pop popClass = new pop();
//                popClass.showPopupWindow(v);
//            }
//        });
        Spinner dropdown = findViewById(R.id.spinner1);
//        String[] items = new String[]{"Male","Female"};
        ArrayAdapter<CharSequence>adapter =  ArrayAdapter.createFromResource(this,R.array.Gender, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
//        dropdown.setOnItemClickListener(this);
    }
////    private void chooseProfilePicture(){
////        AlertDialog.Builder builder = new AlertDialog.Builder(pp.this);
////        LayoutInflater inflater = getLayoutInflater();
////        View dialogView = inflater.inflate(R.layout.fragment_bottomsheet,null);
////        builder.setCancelable(false);
////        builder.setView(dialogView);
////
////        ImageView imageView = dialogView.findViewById(R.id.alert);
////        ImageView imageView1 = dialogView.findViewById(R.id.alert1);
////
////
////        AlertDialog alertDialogProfilePicture = builder.create();
////        alertDialogProfilePicture.show();
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(checkAndRequestPermissions()){
//                    takePictureFromCamera();
//                    alertDialogProfilePicture.cancel();
//                }
//
//            }
//        });
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                takePictureFromGallery();
//                alertDialogProfilePicture.cancel();
//            }
//        });



//    }
    private  void takePictureFromGallery(){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto,
                1);
    }

    private void  takePictureFromCamera(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePicture,2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImageUri = data.getData();
                    imageViewprofilepicture.setImageURI(selectedImageUri);

                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
                    imageViewprofilepicture.setImageBitmap(bitmapImage);
                }
        }
    }
    private boolean checkAndRequestPermissions(){
        if(Build.VERSION.SDK_INT >= 23){
            int camerPermission = ActivityCompat.checkSelfPermission(pp.this, Manifest.permission.CAMERA);
            if(camerPermission == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(pp.this, new String[]{Manifest.permission.CAMERA},20);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            takePictureFromCamera();

        }
        else
            Toast.makeText(pp.this,"Permission not Granted", Toast.LENGTH_LONG).show();



        google1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://accounts.google.com/accountchooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser");

            }
        });

        facebook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/login.php");
            }
        });
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();


    }
    private void gotoUrl(String s)  {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }

}