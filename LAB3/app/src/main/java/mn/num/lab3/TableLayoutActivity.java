package mn.num.lab3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;

public class TableLayoutActivity extends AppCompatActivity {
    private Button btnOk,btnCancel;
    private RadioGroup radioGroup;
    private TimePicker timePicker;
    private RadioButton radioButton1;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        Intent intent = getIntent();
        btnOk = findViewById(R.id.btnOk3);
        btnCancel = findViewById(R.id.btnCancel3);
        radioGroup = findViewById(R.id.genderRadio);
        timePicker = findViewById(R.id.timePicker1);

        String genderId = intent.getStringExtra("genderId");
        String hour =  intent.getStringExtra("hour");
        String minute = intent.getStringExtra("minute");

        if(genderId!=null){
            int genderId1 = Integer.parseInt(genderId);
            radioButton1 =findViewById(genderId1);
            radioButton1.setChecked(true);
        }

        if (hour!=null && minute!=null){
            timePicker.setHour(Integer.parseInt(hour));
            timePicker.setMinute(Integer.parseInt(minute));
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("genderId", String.valueOf(radioGroup.getCheckedRadioButtonId()));
                resultIntent.putExtra("hour", String.valueOf(timePicker.getHour()));
                resultIntent.putExtra("minute", String.valueOf(timePicker.getMinute()));
                setResult(3, resultIntent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}