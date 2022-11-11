package com.example.tp_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkAndro;
    CheckBox chkMicro;
    Button btnAffich;
    RadioGroup radSpecialityType;
    RadioButton radDSI;
    RadioButton radRSI;
    RadioButton radSEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkAndro = (CheckBox) findViewById(R.id.chkAndro);
        chkMicro = (CheckBox) findViewById(R.id.chkMicro);
        btnAffich = (Button) findViewById(R.id.btnAffich);
        radSpecialityType = (RadioGroup)
                findViewById(R.id.radioGroupSpecialiteType);
        radDSI = (RadioButton) findViewById(R.id.radDsi);
        radRSI = (RadioButton) findViewById(R.id.radRsi);
        radSEM =(RadioButton) findViewById(R.id.radSem);
        btnAffich.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View v) {
                    String msg = "Spécialité ";
                    String option="club ";
                    if (chkAndro.isChecked())
                        option=option + chkAndro.getText() ;
                    if (chkMicro.isChecked())
                        option=option + chkMicro.getText();
                int radioId = radSpecialityType.getCheckedRadioButtonId();

                if (radSEM.getId() == radioId)
                    msg = msg+ radSEM.getText() ;
                else if (radRSI.isChecked())
                    msg = msg+ radRSI.getText() ;
                else if (radDSI.isChecked())
                    msg = msg+ radDSI.getText() ;

                Toast.makeText(getApplicationContext(), msg+" "+option, Toast.LENGTH_LONG).show();
            }
        });
    }
}