package android.pakaco.matrixtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/10/18.
 */
public class ColorMatrixActivity extends Activity implements View.OnClickListener{

    private View mChange;
    private View mReset;
    private ImageView mImageView;
    private GridLayout mGridLayout;
    private Bitmap mBitmap;
    private int mEditWidth;
    private int mEditHeight;
    private float[] mColorMatrix = new float[20];
    private EditText[] mEdits = new EditText[20];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matirx);
        mChange = findViewById(R.id.color_change_btn);
        mChange.setOnClickListener(this);
        mReset = findViewById(R.id.color_reset_btn);
        mReset.setOnClickListener(this);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lena);
        mImageView = (ImageView)findViewById(R.id.image_view);
        mImageView.setImageBitmap(mBitmap);
        mGridLayout =(GridLayout)findViewById(R.id.color_gridlayout);
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEditWidth = mGridLayout.getWidth()/5;
                mEditHeight = mGridLayout.getHeight()/4;
                addEditText();
                initColorMatrix();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.color_change_btn:
                change();
                break;
            case R.id.color_reset_btn:
                reset();
                break;
        }

    }


    private void addEditText(){
        for(int i=0;i<20;i++){
            EditText ed = new EditText(ColorMatrixActivity.this);
            //ed.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
            ed.setGravity(Gravity.CENTER);
            mEdits[i] = ed;
            mGridLayout.addView(ed,mEditWidth,mEditHeight);
        }
    }

    private void initColorMatrix(){
        for(int i =0;i<20;i++){
            if(i%6==0){
                mEdits[i].setText(String.valueOf(1));
            }else{
                mEdits[i].setText(String.valueOf(0));
            }
        }
    }


    private void getColorMatrix(){
        for(int i=0;i<20;i++){
            EditText ed = mEdits[i];
            mColorMatrix[i]= Float.parseFloat(ed.getText().toString());
        }
    }

    private void change(){
        getColorMatrix();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(mBitmap,colorMatrix));
    }

    private void reset(){
        initColorMatrix();
        mImageView.setImageBitmap(mBitmap);
    }
}
