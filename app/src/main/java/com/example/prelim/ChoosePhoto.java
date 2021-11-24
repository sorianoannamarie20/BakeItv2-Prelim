package com.example.prelim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ChoosePhoto extends AppCompatActivity {
    private ImageView userPic;
    private TextView choose, upload;
    private FirebaseAuth firebaseAuth;
    private StorageReference storageReference;
    private FirebaseUser firebaseUser;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri uriImage;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_photo);
        getSupportActionBar().hide();

        choose = findViewById(R.id.chooseProfilePic);
        upload = findViewById(R.id.uploadBtn);
        userPic = findViewById(R.id.userProfile);
        backBtn = findViewById (R.id.backBtn);

        backBtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent toEditProfile = new Intent (ChoosePhoto.this, EditProfile.class);
                startActivity (toEditProfile);
            }
        } );

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference("DisplayPics");

        Uri uri = firebaseUser.getPhotoUrl();

        //set user's current DP in ImageView if uploaded already
        Glide.with(ChoosePhoto.this).load(uri).into(userPic);

        //choosing image to upload
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        //upload image
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progressBar.setVisibility(View.VISIBLE);
                UploadPic();

            }
        });

    }

    private void openFileChooser() {
        Intent intent =  new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uriImage = data.getData();
            userPic.setImageURI(uriImage);
        }
    }

    private void UploadPic(){

        ProgressDialog pd =new ProgressDialog(this);
        pd.setMessage("Uploading Photo...");
        pd.show();

        if (uriImage != null) {
            //save the image with id uf the current user
            StorageReference fileReference = storageReference.child(firebaseAuth.getCurrentUser().getUid() + "."
                    + getFileExtension(uriImage));

            //upload image to storage
            fileReference.putFile(uriImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Uri downloadUri = uri;
                            firebaseUser = firebaseAuth.getCurrentUser();

                            //set the display image after uploadingz
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setPhotoUri(downloadUri).build();
                            firebaseUser.updateProfile(profileUpdates);
                        }
                    });

                    pd.dismiss();
                    Toast.makeText(ChoosePhoto.this, "Upload Successful!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ChoosePhoto.this, EditProfile.class);
                    startActivity(intent);
                    finish ();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    pd.dismiss();
                    Toast.makeText(ChoosePhoto.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            pd.dismiss ();
            Toast.makeText(ChoosePhoto.this, "No File Selected", Toast.LENGTH_SHORT).show();
        }

    }

    //obtain file ext of the image
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
}