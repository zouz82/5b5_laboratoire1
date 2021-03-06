package com.example.a5b5_laboratoire1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText textPassword = null;
    CheckBox checkBoxPassword = null;
    TextView textViewPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPassword = (EditText) findViewById(R.id.textPassword);
        checkBoxPassword = (CheckBox) findViewById(R.id.checkBoxPassword);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);

        textViewPassword.setVisibility(View.GONE);

        //onClick_checkBoxPassword();
    }

    public void onCheckBoxPasswordClicked(View view) {

        if (checkBoxPassword.isChecked()){
            // show password
            textPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            // hide password
            textPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public void onButtonValideClicked(View view) {
//        final String VALIDE = textViewPassword;
//        final String NON_VALIDE = textViewPassword.toString();

        if (isValidPassword(textPassword.getText().toString().trim())) {
            //textViewPassword.setText(null);
            textViewPassword.setVisibility(View.VISIBLE);
            textViewPassword.setText(R.string.textViewPasswordValide);
            textViewPassword.setTextColor(getResources().getColor(R.color.Vert));
        } else {
            //textViewPassword.setText(null);
            textViewPassword.setVisibility(View.VISIBLE);
            textViewPassword.setText(R.string.textViewPasswordInvalide);
            textViewPassword.setTextColor(getResources().getColor(R.color.Rouge));
        }

    }

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\@\\#\\$\\%\\&\\(\\)\\[\\]\\{\\}\\_\\=\\<\\>\\+\\-\\!\\?\\*\\/\\|\\:\\;\\.\\,\\‘\\\"\\~\\^])" +
                "([\\da-zA-Z\\@\\#\\$\\%\\&\\(\\)\\[\\]\\{\\}\\_\\=\\<\\>\\+\\-\\!\\?\\*\\/\\|\\:\\;\\.\\,\\‘\\\"\\~\\^]){10,}";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}