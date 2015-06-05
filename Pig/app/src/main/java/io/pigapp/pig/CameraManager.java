package io.pigapp.pig;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wojtekswiderski on 15-06-05.
 */
public class CameraManager extends Activity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    private Context mContext;
    private Uri mFileUri;
    private Intent mCameraIntent;

    public CameraManager(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {


        mFileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image

        // create Intent to take a picture and return control to the calling application
        mCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mFileUri);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to:\n" +
                        mFileUri, Toast.LENGTH_LONG).show();
                Drawable dr = null;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(mFileUri);
                    dr = Drawable.createFromStream(inputStream, mFileUri.toString() );
                } catch (FileNotFoundException e) {
                    Log.e("MainActivity", "Could not open file");
                }
            }
        }
    }

    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Pig");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }
}
