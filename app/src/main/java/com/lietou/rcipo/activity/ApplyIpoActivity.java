package com.lietou.rcipo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lietou.rcipo.R;
import com.lietou.rcipo.utils.AppConstants;

/**
 * 申请IPO的Activity
 */
public class ApplyIpoActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_ipo);

        initView();
    }

    private void initView() {
        webView = ((WebView) findViewById(R.id.applyipo_wv));
        webView.loadUrl(AppConstants.APPLYIPO_URL);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//支持javascript
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}
