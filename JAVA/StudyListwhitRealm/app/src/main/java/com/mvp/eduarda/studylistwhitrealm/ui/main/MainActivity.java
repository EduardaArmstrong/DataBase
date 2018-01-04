package com.mvp.eduarda.studylistwhitrealm.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvp.eduarda.studylistwhitrealm.R;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
