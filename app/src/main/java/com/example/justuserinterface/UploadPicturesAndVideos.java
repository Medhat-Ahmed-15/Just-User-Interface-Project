package com.example.justuserinterface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class UploadPicturesAndVideos extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button back_button;
    Button uploadPicture_button;
    Button uploadVideo_button;
    Button crop_button;

    ImageView imageview;
    VideoView videoView;

    MediaController mediaController;

    int requestCd=1;
    int pickVideoRequest=1;
    int flag;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pictures_and_videos);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        back_button=(Button) findViewById(R.id.back_button);
        crop_button=(Button) findViewById(R.id.crop_button);
        uploadPicture_button=(Button) findViewById(R.id.uploadPicture_button);
        uploadVideo_button=(Button) findViewById(R.id.uploadVideo_button);
        imageview=(ImageView) findViewById(R.id.imageView4);
        videoView=(VideoView) findViewById(R.id.videoView);



        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        uploadPicture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i,1);

                flag=1;
            }
        });


        crop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Intent intent = new Intent("com.android.camera.action.CROP");
                //intent.setClassName("com.example.justuserinterface", "com.example.justuserinterface.UploadPicturesAndVideos");
                File file = new File(Environment.getExternalStorageDirectory()+"/temp.jpg");
                Uri uri = Uri.fromFile(file);
                intent.setData(uri);
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputX", 96);
                intent.putExtra("outputY", 96);
               // intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                intent.putExtra("outputFormat",Bitmap.CompressFormat.JPEG.toString());
                intent.putExtra("noFaceDetection", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 3);

                flag=3;
            }
        });



        uploadVideo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("video/*");
                startActivityForResult(Intent.createChooser(i,"Select Video"),2);
                flag=2;
            }
        });



        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    public void back(){
        Intent intent=new Intent(this,Mobille_Application_Assignment.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

           if(flag==1) {
               if (requestCode == 1 && resultCode == RESULT_OK) {
                    uri = data.getData();


                   try {

                       Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                       imageview.setImageBitmap(bitmap);

                   } catch (IOException e) {
                       e.printStackTrace();
                   }

               }


           }
           //////////////////////////////////////////////////////////
           else if(flag==2){
        if(requestCode==2&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null)
        {
            Uri uri =data.getData();
            videoView.setVideoURI(uri);
            mediaController=new MediaController(this);
            videoView.setMediaController(mediaController);
            videoView.start();
        }

    }
           //////////////////////////////////////////////////////////////////
           else if(flag==3){

               if (requestCode == 3 && resultCode == RESULT_OK) {

                   Bundle extras = data.getExtras();
                   if(extras != null ) {
                       Bitmap photo = extras.getParcelable("data");
                       ByteArrayOutputStream stream = new ByteArrayOutputStream();
                       photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);
                       // The stream to write to a file or directly using the photo

               }




               }
           }


}
}