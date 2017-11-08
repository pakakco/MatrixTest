package android.pakaco.matrixtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2017/10/18.
 */
public class ImageProcessActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private static final String TAG = "ImageProcessActivity";
    private ImageView mImageView;
    private SeekBar mSeekBarHue,mSeekBarSaturation,mSeekBarlum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE=172;
    private static int MIN_VALUE=0;

    private float mHue=-1.0f,mSaturation=-1.0f,mLum=-1.0f;
    private Bitmap mBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_process);
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lena);
        mImageView=(ImageView)findViewById(R.id.image_view);
        mSeekBarHue=(SeekBar)findViewById(R.id.hue_seekbar);
        mSeekBarHue.setOnSeekBarChangeListener(this);
        mSeekBarSaturation=(SeekBar)findViewById(R.id.saturation_seekbar);
        mSeekBarSaturation.setOnSeekBarChangeListener(this);
        mSeekBarlum=(SeekBar)findViewById(R.id.lum_seekbar);
        mSeekBarlum.setOnSeekBarChangeListener(this);
       // mSeekBarHue.setProgress(MID_VALUE);
       // mSeekBarSaturation.setProgress(MID_VALUE);
        //mSeekBarlum.setProgress(MID_VALUE);
        mImageView.setImageBitmap(mBitmap);
        mSeekBarlum.setMax(MAX_VALUE);
        mSeekBarHue.setMax(MAX_VALUE);
        mSeekBarSaturation.setMax(MAX_VALUE);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d(TAG,"onProgressChanged  progress= "+progress+"; fromUser: "+fromUser);
        if(!fromUser) return;

        switch (seekBar.getId()){
            case R.id.hue_seekbar:
                mHue = progress*1.0f/MAX_VALUE*360;
                break;
            case R.id.saturation_seekbar:
                mSaturation = progress*1.0f/MAX_VALUE;
                break;
            case R.id.lum_seekbar:
                mLum = progress*1.0f/(MID_VALUE/3);
                break;
        }

        mImageView.setImageBitmap(ImageHelper.handleImageEffect(mBitmap,mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
