package a816.android.soldesk.jungangrssfeeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_content);

//        TextView tv_content = (TextView)findViewById(R.id.tv_content);
        String content = getIntent().getStringExtra("content");
//        tv_content.setText(content);
        TextView tv = new TextView(this);
        tv.setText(content);

        ScrollView sv = new ScrollView(this);
        sv.addView(tv);

        setContentView(sv);

        setTitle("뉴스 내용 보여~");
    }
}