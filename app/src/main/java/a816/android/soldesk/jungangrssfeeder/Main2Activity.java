package a816.android.soldesk.jungangrssfeeder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Comparator;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bt_cho = (Button) findViewById(R.id.bt_cho);
        Button bt_jung = (Button) findViewById(R.id.bt_jung);
        Button bt_dong = (Button) findViewById(R.id.bt_dong);

        bt_cho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtra("company","cho");
                startActivity(intent);
            }
        });
        bt_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtra("company","dong");
                startActivity(intent);
            }
        });
        bt_jung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtra("company","jung");
                startActivity(intent);
            }
        });

    }
}
