package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        //Para validar todas as situaçoes do input text
        username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaUser();
            }
        });


        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaPass();
            }
        });
    }

    @OnClick(R.id.btConectar)
    public void conectar() {
        if (validaUser() && validaPass()){
            //Cria a intencao para chamar novo activty
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("USUARIO", username.getEditText()
                                         .getText()
                                         .toString());

            i.putExtra("SENHA", password.getEditText()
                    .getText()
                    .toString());

            startActivity(i);
        }
    }

    private boolean validaUser() {
        if(username.getEditText().getText().toString().isEmpty()) {
            username.setError("Login não informado");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

    private boolean validaPass() {
        if (password.getEditText().getText().toString().isEmpty()) {
            password.setError("Senha não informado");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }

}
