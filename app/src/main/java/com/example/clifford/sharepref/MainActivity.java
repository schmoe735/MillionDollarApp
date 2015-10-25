package com.example.clifford.sharepref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView buckysTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = (EditText)findViewById(R.id.usernameInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        buckysTextView = (TextView)findViewById(R.id.buckysTextView);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username",usernameInput.getText().toString());
        editor.putString("password",passwordInput.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
    }

    public void getInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username", "");
        String pass = sharedPref.getString("password","");
        buckysTextView.setText(name + " "+ pass);
    }
}
