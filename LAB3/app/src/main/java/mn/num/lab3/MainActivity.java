package mn.num.lab3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String act1Name="",act1Age="";
    String act2Cb1="",act2Cb2="",act2Cb3="";
    String act3GenderId="",act3Hour="",act3Minute="";
    String act4Rating="", act4Hour="", act4Minute="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act1Menu:
                Log.v("clicked","Activity 1 menu clicked");
                openActivity1();
                return true;
            case R.id.act2Menu:
                Log.v("clicked","Activity 2 menu clicked");
                openActivity2();
                return true;
            case R.id.act3Menu:
                Log.v("clicked","Activity 3 menu clicked");
                openActivity3();
                return true;
            case R.id.act4Menu:
                Log.v("clicked","Activity 4 menu clicked");
                openActivity4();
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    public void onFrameLayoutClicked(View view){
        Intent intent = new Intent();
        intent.setClassName("mn.num.lab3","mn.num.lab3.FrameLayoutActivity");
        if (!act1Name.equals("")){
            intent.putExtra("name", act1Name);
        }
        if (!act1Age.equals("")){
            intent.putExtra("age", act1Age);
        }
        startActivityForResult(intent, 1);
    }
    public void onLinearLayoutClicked(View view){
        Intent intent = new Intent();
        intent.setClassName("mn.num.lab3","mn.num.lab3.LinearLayoutActivity");

        if (!act2Cb1.equals("")){
            intent.putExtra("cb1", act2Cb1);
        }
        if (!act2Cb2.equals("")){
            intent.putExtra("cb2", act2Cb2);
        }
        if (!act2Cb3.equals("")){
            intent.putExtra("cb3", act2Cb3);
        }
        startActivityForResult(intent, 1);
    }

    public void onTableLayoutClicked(View view){
        Intent intent = new Intent();
        intent.setClassName("mn.num.lab3","mn.num.lab3.TableLayoutActivity");
        if (!act3GenderId.equals("")){
            intent.putExtra("genderId", act3GenderId);
        }
        if (!act3Hour.equals("")){
            intent.putExtra("hour",act3Hour);
            intent.putExtra("minute", act3Minute);
        }
        startActivityForResult(intent, 1);
    }

    public void onRelativeLayoutClicked(View view){
        Intent intent = new Intent();
        intent.setClassName("mn.num.lab3","mn.num.lab3.RelativeLayoutActivity");
        if (!act4Rating.equals("")){
            intent.putExtra("rating", act4Rating);
        }
        if (!act4Hour.equals("")){
            intent.putExtra("hour",act4Hour);
            intent.putExtra("minute", act4Minute);
        }
        startActivityForResult(intent, 1);
    }

    public void openActivity1(){
        Intent intent = new Intent(this, FrameLayoutActivity.class);
        if (!act1Name.equals("")){
            intent.putExtra("name", act1Name);
        }
        if (!act1Age.equals("")){
            intent.putExtra("age", act1Age);
        }
        startActivityForResult(intent, 1);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, LinearLayoutActivity.class);
        if (!act2Cb1.equals(""))
            intent.putExtra("cb1", act2Cb1);
        if (!act2Cb2.equals(""))
            intent.putExtra("cb2", act2Cb2);
        if (!act2Cb3.equals(""))
            intent.putExtra("cb3", act2Cb3);
        startActivityForResult(intent, 1);
    }

    public void openActivity3(){
        Intent intent = new Intent(this, TableLayoutActivity.class);
        if (!act3GenderId.equals("")){
            intent.putExtra("genderId", act3GenderId);
        }
        if (!act3Hour.equals("")){
            intent.putExtra("hour",act3Hour);
            intent.putExtra("minute", act3Minute);
        }
        startActivityForResult(intent, 1);
    }

    public void openActivity4(){
        Intent intent = new Intent(this, RelativeLayoutActivity.class);
        if (!act4Rating.equals("")){
            intent.putExtra("rating", act4Rating);
        }
        if (!act4Hour.equals("")){
            intent.putExtra("hour",act4Hour);
            intent.putExtra("minute", act4Minute);
        }
        startActivityForResult(intent, 1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            act1Name = data.getStringExtra("name");
            act1Age = data.getStringExtra("age");
        } else
        if(resultCode == 2){
            act2Cb1 = data.getStringExtra("cb1");
            act2Cb2 = data.getStringExtra("cb2");
            act2Cb3 = data.getStringExtra("cb3");
        }   else
         if(resultCode == 3){
            act3GenderId = data.getStringExtra("genderId");
            act3Hour = data.getStringExtra("hour");
            act3Minute = data.getStringExtra("minute");
        } else
        if(resultCode == 4){
             act4Rating = data.getStringExtra("rating");
             act4Hour = data.getStringExtra("hour");
             act4Minute = data.getStringExtra("minute");
         }
    }
}