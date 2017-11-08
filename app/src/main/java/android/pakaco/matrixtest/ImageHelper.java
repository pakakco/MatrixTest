package android.pakaco.matrixtest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/10/18.
 */
public class ImageHelper {

    public static Bitmap handleImageEffect(Bitmap bm,float hue,float saturation,float luma){
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        if(hue>=0) {
            hueMatrix.setRotate(0, hue);
            hueMatrix.setRotate(1, hue);
            hueMatrix.setRotate(2, hue);
        }

        ColorMatrix saturationMatrix = new ColorMatrix();
        if(saturation>=0)
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumaMatrix =  new ColorMatrix();
        if(luma>=0)
        lumaMatrix.setScale(luma,luma,luma,1);

        ColorMatrix imageMatirx  = new ColorMatrix();
        imageMatirx.postConcat(hueMatrix);
        imageMatirx.postConcat(saturationMatrix);
        imageMatirx.postConcat(lumaMatrix);
        paint.setColorFilter(new ColorMatrixColorFilter(imageMatirx));
        canvas.drawBitmap(bm,0,0,paint);
        return  bitmap;
    }


    public static Bitmap handleImageEffect(Bitmap bm,ColorMatrix colorMatrix){
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bm,0,0,paint);
        return  bitmap;
    }
}
