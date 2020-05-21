package com.example.validacaoluizhenrique;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewMain = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewMain.btn_registrar = this.findViewById(R.id.btn_registrar);

        this.mViewMain.btn_registrar.setOnClickListener(this);

    }
    public void onClick(View view){
        if (view.getId() == R.id.btn_registrar){
            Intent acessoTelaRegistro = new Intent(MainActivity.this,RegistroActivity.class);
            startActivity(acessoTelaRegistro);
        }

    }

    static class ViewHolder{
        private Button btn_registrar;
    }


}
