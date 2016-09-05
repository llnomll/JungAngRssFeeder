package a816.android.soldesk.jungangrssfeeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String url = getIntent().getStringExtra("url");
        WebView wv = (WebView) findViewById(R.id.webview_content);
        wv.loadUrl(url);

    }
}