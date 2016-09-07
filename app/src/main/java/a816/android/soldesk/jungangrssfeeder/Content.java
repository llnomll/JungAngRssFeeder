package a816.android.soldesk.jungangrssfeeder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Set;

public class Content extends AppCompatActivity {

    private WebView wv;
    TextView textViewlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

       /* textViewlist = (TextView) findViewById(R.id.textView_list);*/


        String url = getIntent().getStringExtra("url");
        wv = (WebView) findViewById(R.id.webview_content);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setSupportZoom(true);
        wv.getSettings().setDisplayZoomControls(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.loadUrl(url);

    }

    public void onClickBtnBack(View view) {
       finish();

    }

}