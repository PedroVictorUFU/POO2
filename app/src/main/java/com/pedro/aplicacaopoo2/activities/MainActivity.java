package com.pedro.aplicacaopoo2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pedro.aplicacaopoo2.R;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.et_email)
    EditText etEmail;

    @Bind(R.id.et_password)
    EditText etPassword;

    private RequestQueue requestQueue;
    private String urlLogin = "http://10.0.3.2:12345/login";

    private int i = 0;
    @OnClick(R.id.bt_login)
    public void fazLogin(){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("true")){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erro_login",error.toString());
                Toast.makeText(MainActivity.this, "Usuário e/ou senha inválidos", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError {
                String httpPostBody="{\"user\":\""+etEmail.getText().toString()+"\",\"password\":\""+etPassword.getText().toString()+"\"}";
                return httpPostBody.getBytes();
            }
        };

        requestQueue.add(stringRequest);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        requestQueue = Volley.newRequestQueue(this);
        ButterKnife.bind(this);
    }


}
