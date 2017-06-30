package mobappdev.demo.finalexam.problem4;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Tkha on 6/29/17.
 */

public class AsyncDownload extends AsyncTask<String, Void, Bitmap> {
    private static final String TAG = "async";

    private ImageView bmImage;
    private Context cContext;

    private ImageDownloaderActivity mDownloader;

    public AsyncDownload(ImageView bmImage, Context context) {
        this.bmImage = bmImage;
        cContext = context;
    }

    public Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap img = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            img = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            Log.i(TAG, "doInBackground: error");
        }
        return img;
    }

    public void onPostExecute(Bitmap result) {

        // Create new directory
        ContextWrapper wrapper = new ContextWrapper(cContext);
        File path = wrapper.getDir("Images",MODE_PRIVATE);
        path = new File(path, "IMG.jpg");

        try {
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(path);
            result.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        // Set ImageView
        Uri savedImageURI = Uri.parse(path.getAbsolutePath());
        Log.i(TAG, "onPostExecute: path: " + savedImageURI);
        bmImage.setImageURI(savedImageURI);

    }


}
