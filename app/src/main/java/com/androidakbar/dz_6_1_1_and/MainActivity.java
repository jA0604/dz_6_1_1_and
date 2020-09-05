package com.androidakbar.dz_6_1_1_and;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TV_KEY = "TextViewContent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));
        appToolbar.setTitleTextAppearance(this, R.style.ToolBarTitleTextAppearance);

        if (savedInstanceState == null) {
            LogSet("onCreate, Bundle is null");
        } else {
            LogSet("onCreate, Bundle is not null");
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        LogSet("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogSet("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogSet("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogSet("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogSet("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogSet("onRestart");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LogSet("onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        LogSet("onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogSet("onKeyDown");
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            event.startTracking();
            LogSet("Key Down" + KeyEvent.KEYCODE_MENU);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        LogSet("onKeyLongPress");
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            event.startTracking();
            LogSet("Key Long Down" + KeyEvent.KEYCODE_MENU);
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogSet("onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        LogSet("onSaveInstanceState");
        outState.putCharSequence(TV_KEY, ((TextView)findViewById(R.id.txt_cycle)).getText());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogSet("onRestoreInstanceState");
        ((TextView)findViewById(R.id.txt_cycle)).setText(savedInstanceState.getCharSequence(TV_KEY));
    }

    private void LogSet(String methodName) {
        Log.d("Lifecycle", methodName);
        ((TextView)findViewById(R.id.txt_cycle)).append("\n" + methodName);
    }
}