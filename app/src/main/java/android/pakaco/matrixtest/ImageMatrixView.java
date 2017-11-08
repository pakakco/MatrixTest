package android.pakaco.matrixtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ImageMatrixView extends View {

    private Bitmap mBitmap;
    private Matrix mMatrix;
    public ImageMatrixView(Context context) {
        super(context);
        initView();
    }

    public ImageMatrixView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    public ImageMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ImageMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    private  void initView(){
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        setImageMatrix(new Matrix());
    }

    public void setImageMatrix(Matrix matrix){
        mMatrix = matrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,null);
        canvas.drawBitmap(mBitmap,mMatrix,null);
    }
}
