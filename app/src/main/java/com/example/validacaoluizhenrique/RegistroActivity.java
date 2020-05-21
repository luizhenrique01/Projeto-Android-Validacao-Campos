package com.example.validacaoluizhenrique;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewRegistro = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.mViewRegistro.btn_salvar = this.findViewById(R.id.btn_salvar);
        this.mViewRegistro.edit_email = this.findViewById(R.id.edit_email);
        this.mViewRegistro.edit_cpf = this.findViewById(R.id.edit_cpf);
        this.mViewRegistro.edit_nome = this.findViewById(R.id.edit_nome);
        this.mViewRegistro.edit_telefone = this.findViewById(R.id.edit_telefone);
        this.mViewRegistro.cbx_confirmar = this.findViewById(R.id.cbx_confirmar);
        //setOnClick
        this.mViewRegistro.btn_salvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btn_salvar){
            if (validaCampos() == false){
                MensagemDeErro("Dados incorretos");
            }else{
                MensagemDeErro("Dados Corretos");
            }
        }

    }
    private boolean validaCampos() {
        boolean resultado = false;

        if (resultado = isCampoVazio(this.mViewRegistro.edit_nome.getText().toString())) {
            this.mViewRegistro.edit_nome.requestFocus();
        }
        if (resultado = isCpfVazio(this.mViewRegistro.edit_cpf.getText().toString())) {
            this.mViewRegistro.edit_cpf.requestFocus();
        }
        if (resultado = isTelefoneVazio(this.mViewRegistro.edit_cpf.getText().toString())) {
            this.mViewRegistro.edit_telefone.requestFocus();
        }

        if (resultado = !isEmailValido(this.mViewRegistro.edit_email.getText().toString())) {
            this.mViewRegistro.edit_email.setError("Email invalido");
            this.mViewRegistro.edit_email.requestFocus();
        }

        if (!this.mViewRegistro.cbx_confirmar.isChecked()) {
            resultado = false;
        }else{
            resultado = true;
        }
        return resultado;

    }

    private boolean isCampoVazio(String valor){
        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
    }
    private boolean isCpfVazio(String valor){
        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
    }
    private boolean isTelefoneVazio(String valor){
        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
    }

    private boolean isEmailValido(String email){
        return (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void MensagemDeErro(String mensagem){
        AlertDialog.Builder Msg = new AlertDialog.Builder(RegistroActivity.this);
        Msg.setMessage(mensagem);
        Msg.setNeutralButton("Sair",null);
        Msg.create();
        Msg.show();
    }

    private static class ViewHolder{
        private Button btn_salvar;
        private EditText edit_nome;
        private EditText edit_cpf;
        private EditText edit_telefone;
        private EditText edit_email;
        private CheckBox cbx_confirmar;
    }

}
