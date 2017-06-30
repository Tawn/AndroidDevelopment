package mobappdev.demo.finalexam.problem4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import mobappdev.demo.finalexam.R;

public class ImageDownloaderActivity extends AppCompatActivity {
    private static final String TAG = "ImgDler";
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_downloader);
        ivImage = (ImageView)findViewById(R.id.iv_image);
    }

    public void downloadPressed(View view) {
        String imgUrl = "https://vetstreet.brightspotcdn.com/dims4/default/8293303/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F0e%2F9f%2F74334f874e899e8e8a6a33752c91%2Fbasset-hound-AP-0T0WDB-645sm12913.jpg";
        new AsyncDownload((ImageView) findViewById(R.id.iv_image), getApplicationContext()).execute(imgUrl);
        ivImage.buildDrawingCache();
        Bitmap bmImage = ivImage.getDrawingCache();
        ivImage.setImageBitmap(bmImage);
    }


    // use this method to scale the image
    private Bitmap getScaledBitmap(String path) {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    private static Bitmap getScaledBitmap(String path, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        Log.d(TAG, "requested width=" + width + "," + "requested height=" + height);
        Log.d(TAG, "srcWidth=" + srcWidth + "," + "srcHeight=" + srcHeight);

        int sampleSize = 1;
        if(srcHeight > height || srcWidth > width ) {
            if(srcWidth > srcHeight) {
                sampleSize = Math.round(srcHeight / height);
            }
            else {
                sampleSize = Math.round(srcWidth / width);
            }
        }

        Log.d(TAG, "sampleSize=" + sampleSize);

        BitmapFactory.Options scaledOptions = new BitmapFactory.Options();
        scaledOptions.inSampleSize = sampleSize;

        //return BitmapFactory.decodeFile(path, scaledOptions);
        return BitmapFactory.decodeFile(path);
    }


}
