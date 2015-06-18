package br.ufms.gerenciadordedespesas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gabriel on 23/05/2015.
 */
public class InserirCategoria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_categoria);
    }
    public void onClickButtonSalvar(View view){
        EditText texto = (EditText)findViewById(R.id.editText);
        String categoria = texto.getText().toString().trim();
        if(categoria.matches("")){
            Toast.makeText(this,"Nenhuma Categoria Escrita",Toast.LENGTH_SHORT).show();
        }
        else{
            int i,j;
            String a = "";
            Intent intent = new Intent(this,Categorias.class);
            boolean t =true;

            for(j=0; j< categoria.length();j++){
                char c = categoria.charAt(j);
                if((c > 32 && c < 65) || (c > 90 && c < 97) || (c > 122 && c < 127)){
                    a+= c;
                    t = false;
                }
            }

            for(i=0;i<RegistrarFinancas.categorias.size() && !(RegistrarFinancas.categorias.get(i).equalsIgnoreCase(categoria)) && t ;i++){}

            if(i == RegistrarFinancas.categorias.size()){
                intent.putExtra("categoria",categoria);
            }
            else{
                if(!t) {
                    Toast.makeText(this,"Caracteres "+a+" invalidos",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this,"Categoria ja existente!",Toast.LENGTH_SHORT).show();
            }
            startActivity(intent);
        }
    }
    public void onClickButtonCancelar(View view){
        Intent intent = new Intent(this,Categorias.class);
        startActivity(intent);
    }
}
