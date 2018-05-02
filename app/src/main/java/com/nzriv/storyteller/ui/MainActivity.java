package com.nzriv.storyteller.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nzriv.storyteller.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button startButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString();
        startStory(name);
    }
//    Resets the name edittext field when we press back/up back to the start page.
    @Override
    protected void onResume() {
        super.onResume();
        editText.setText("");
    }

    private void startStory(String name) {
//        creates Intent to start new activity of (intent)
//        then transfers data with key "name"
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
//        grabs name resource from strings.xml
//        Resources resources = getResources();
//        String key = resources.getString(R.string.key_name);
        String key = getString(R.string.key_name);
        intent.putExtra(key , name);
        startActivity(intent);
    }
}
