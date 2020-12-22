package mn.num.lab3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TimePicker;

public class RelativeLayoutActivity extends AppCompatActivity {
    private Button btnOk,btnCancel;
    private RatingBar rating;
    private TimePicker timePicker;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        Intent intent = getIntent();
        btnOk = findViewById(R.id.btnOk4);
        btnCancel = findViewById(R.id.btnCancel4);
        rating = findViewById(R.id.ratingBar);
        timePicker = findViewById(R.id.relativeTimePicker);
        String rate =intent.getStringExtra("rating");
        String hour = intent.getStringExtra("hour");
        String minute = intent.getStringExtra("minute");

        if(rate != null){
            rating.setRating(Float.parseFloat(rate));
        }
        if (hour!=null && minute!=null){
            timePicker.setHour(Integer.parseInt(hour));
            timePicker.setMinute(Integer.parseInt(minute));
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float getrating = rating.getRating();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("rating",String.valueOf(getrating));
                resultIntent.putExtra("hour", String.valueOf(timePicker.getHour()));
                resultIntent.putExtra("minute", String.valueOf(timePicker.getMinute()));

                setResult(4, resultIntent);
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