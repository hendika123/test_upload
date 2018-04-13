package com.example.aloy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.edt_width) EditText etwitdh;
    @BindView(R.id.edt_leght) EditText etlight;
    @BindView(R.id.btn_calculate) Button etcalculate;
    @BindView(R.id.tv_result) TextView ettvresult;
    @BindView(R.id.edt_height) EditText etheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        etcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_calculate) {
                    String leght = etlight.getText().toString().trim();
                    String width = etwitdh.getText().toString().trim();
                    String height = etheight.getText().toString().trim();
                    boolean isEmptyFields = false;
                    if (TextUtils.isEmpty(leght)) {
                        isEmptyFields = true;
                        etlight.setError("Field ini tidak boleh kosong");
                    }
                    if (TextUtils.isEmpty(width)) {
                        isEmptyFields = true;
                        etwitdh.setError("Field ini tidak boleh kosong");
                    }
                    if (TextUtils.isEmpty(height)) {
                        isEmptyFields = true;
                        etheight.setError("Field ini tidak boleh kosong");
                    }
                    if (!isEmptyFields) {
                        double l = Double.parseDouble(leght);
                        double w = Double.parseDouble(width);
                        double h = Double.parseDouble(height);
                        double volume = l * w * h;
                        ettvresult.setText(String.valueOf(volume));
                    }
                }

            }
        });

    }

}
