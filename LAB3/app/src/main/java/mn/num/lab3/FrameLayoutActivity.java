package mn.num.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FrameLayoutActivity extends AppCompatActivity {
    private Button btnOk,btnCancel;
    private EditText etName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        Intent intent = getIntent();
        btnOk = findViewById(R.id.btnOk1);
        btnCancel = findViewById(R.id.btnCancel1);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        etName.setText(name);
        etAge.setText(age);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name",etName.getText().toString());
                resultIntent.putExtra("age",etAge.getText().toString());
                setResult(1,resultIntent);
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