package mn.num.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class LinearLayoutActivity extends AppCompatActivity {
    private Button btnOk,btnCancel;
    private CheckBox cb1,cb2,cb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        Intent intent = getIntent();
        btnOk = findViewById(R.id.btnOk2);
        btnCancel = findViewById(R.id.btnCancel2);
        cb1 = findViewById(R.id.checkboxVehicle);
        cb2 = findViewById(R.id.checkboxAnime);
        cb3 = findViewById(R.id.checkboxRead);
        String vehicle = intent.getStringExtra("cb1");
        String anime = intent.getStringExtra("cb2");
        String read = intent.getStringExtra("cb3");
        cb1.setChecked(Boolean.parseBoolean(vehicle));
        cb2.setChecked(Boolean.parseBoolean(anime));
        cb3.setChecked(Boolean.parseBoolean(read));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("cb1",String.valueOf(cb1.isChecked()));
                resultIntent.putExtra("cb2",String.valueOf(cb2.isChecked()));
                resultIntent.putExtra("cb3",String.valueOf(cb3.isChecked()));
                setResult(2,resultIntent);
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