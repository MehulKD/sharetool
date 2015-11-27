package com.hanks.otherkiller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ShareSDK shareSDK;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareSDK = new ShareSDK();
        shareSDK.init(this);

    }

    public void share(View view) {
        shareSDK.share(new ShareParams());
    }
}
