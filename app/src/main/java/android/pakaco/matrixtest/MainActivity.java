package android.pakaco.matrixtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View mImageMatrixBtn;
    private View mColorMatrixBtn;
    private View mImageProcessBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageMatrixBtn = findViewById(R.id.ImageMatrixBtn);
        mColorMatrixBtn = findViewById(R.id.ColorMatrixBtn);
        mImageProcessBtn= findViewById(R.id.ImageProcessBtn);
        mImageMatrixBtn.setOnClickListener(this);
        mColorMatrixBtn.setOnClickListener(this);
        mImageProcessBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ImageMatrixBtn: {
                Intent intent = new Intent(this, ImageMatrixActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.ColorMatrixBtn: {
                Intent intent = new Intent(this, ColorMatrixActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.ImageProcessBtn: {
                Intent intent = new Intent(this, ImageProcessActivity.class);
                startActivity(intent);
            }
                break;
        }
    }
}
