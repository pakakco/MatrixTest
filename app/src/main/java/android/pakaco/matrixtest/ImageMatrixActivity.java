package android.pakaco.matrixtest;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ImageMatrixActivity extends Activity implements View.OnClickListener{


    private GridLayout mGridLayout;
    private View mChangeBtn;
    private View mResetBtn;
    private ImageMatrixView mImageMatrixView;
    private int mEditWidth;
    private int mEditHeight;
    private float[] mImageMatrix = new float[9];
    private EditText[] mEdits = new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matrix);
        mImageMatrixView = (ImageMatrixView)findViewById(R.id.image_matrix_view);
        mGridLayout = (GridLayout)findViewById(R.id.grid_layout);
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEditWidth = mGridLayout.getWidth()/3;
                mEditHeight = mGridLayout.getHeight()/3;
                addEditText();
                initImageMatrix();
            }
        });
        mChangeBtn= findViewById(R.id.changeBtn);
        mChangeBtn.setOnClickListener(this);
        mResetBtn = findViewById(R.id.resetBtn);
        mResetBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.changeBtn:
                change();
                break;
            case R.id.resetBtn:
                reset();
                break;
        }

    }


    private void addEditText(){
        for(int i=0;i<9;i++){
            EditText ed = new EditText(ImageMatrixActivity.this);
            ed.setGravity(Gravity.CENTER);
            mEdits[i] = ed;
            mGridLayout.addView(ed,mEditWidth,mEditHeight);
        }
    }


    private void initImageMatrix(){
        for(int i =0;i<9;i++){
            if(i%4==0){
                mEdits[i].setText(String.valueOf(1));
            }else{
                mEdits[i].setText(String.valueOf(0));
            }
        }
    }


    private void getImageMatrix(){
        for(int i=0;i<9;i++){
            EditText ed = mEdits[i];
            String  value= ed.getText().toString();
            if(value ==null||value.equals("")){
                value="0";
                ed.setText("0");
            }
            mImageMatrix[i]= Float.parseFloat(value);
        }
    }

    private void change(){
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);
        mImageMatrixView.invalidate();
    }

    private void reset(){
        initImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);
        mImageMatrixView.invalidate();
    }
}
