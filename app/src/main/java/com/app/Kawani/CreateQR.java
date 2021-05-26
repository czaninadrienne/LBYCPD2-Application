package com.app.Kawani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CreateQR extends AppCompatActivity {

    String editText;
    ImageView imageView;

    private PreviewView previewView;
    private Button generateQRCode;
    private String qrCode;

    public void run(){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(editText, BarcodeFormat.QR_CODE,800,800);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        previewView = findViewById(R.id.activity_CreateQR_previewView);

        generateQRCode = findViewById(R.id.activity_CreateQR_generateQRCode);
        generateQRCode.setVisibility(View.INVISIBLE);
        generateQRCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), qrCode, Toast.LENGTH_SHORT).show();
                Log.i(MainActivity.class.getSimpleName(), "QR Code generated: " + qrCode);
            }
        });

        String fName = "Myles Earvin";
        String lName = "Uy";
        String idNum = "11806303";

        editText = fName + "," + lName + "," + idNum;
        imageView = (ImageView)findViewById(R.id.imageview);
        run();
    }
}