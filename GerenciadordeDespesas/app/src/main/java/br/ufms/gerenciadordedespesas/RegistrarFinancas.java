package escobar.gabriel.engsoftware;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class RegistrarFinancas extends ActionBarActivity {


    AdapterView<?> pagamentoParent, categoriaParent;
    int pagamentoPosition, categoriaPosition;
    Spinner spinner_pagamento,spinner_categoria;
    ArrayAdapter<CharSequence> adapter_pagamento;
    public static ArrayList<String> categorias = new ArrayList<String>();
    public static ArrayList<Financas> financas = new ArrayList<Financas>();
    static boolean ver = true;


    RadioButton a1;
    RadioButton a2;
    RadioButton a3;
    RadioButton a4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_financas);

        if(ver){
            categorias.add("Nenhuma");
            ver = false;
        }
        spinner_pagamento = (Spinner)findViewById(R.id.spinner2);
        adapter_pagamento = ArrayAdapter.createFromResource(this,R.array.pagamento,android.R.layout.simple_spinner_item);
        adapter_pagamento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pagamento.setAdapter(adapter_pagamento);
        spinner_pagamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pagamentoParent = parent;
                pagamentoPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_categoria = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,RegistrarFinancas.categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_categoria.setAdapter(adapter);
        spinner_categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> paren, View view, int positio, long i) {
                categoriaParent = paren;
                categoriaPosition = positio;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        a1 = (RadioButton)findViewById(R.id.radioButton);
        a2 = (RadioButton)findViewById(R.id.radioButton2);
        a3 = (RadioButton)findViewById(R.id.radioButton3);
        a4 = (RadioButton)findViewById(R.id.radioButton4);
        a1.setChecked(true);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a2.setChecked(false);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setChecked(false);
            }
        });


        a3.setOnClickListener(new View.OnClickListener() {
            boolean pre = false;
            @Override
            public void onClick(View v) {
                if(a3.isChecked() && pre){

                    a3.setChecked(false);
                    pre = false;

                }
                else{
                    pre = true;
                    a3.setChecked(true);
                }
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            boolean pre = false;
            @Override
            public void onClick(View v) {
                if(a4.isChecked() && pre){

                    a4.setChecked(false);
                    pre = false;
                    EditText a  = (EditText)findViewById(R.id.editText7);
                    a.setVisibility(View.INVISIBLE);

                }
                else{
                    pre = true;
                    a4.setChecked(true);
                    EditText a  = (EditText)findViewById(R.id.editText7);
                    a.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    public void onClickInserirExcluir(View v){
        Intent a = new Intent(this,Categorias.class);
        startActivityForResult(a,0);
    }

    public void onClickButtonCancel(View v){
        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);
    }
    public void onClickSalvarDados(View v){
        EditText nome = (EditText)findViewById(R.id.editText4);
        EditText valor = (EditText)findViewById(R.id.editText5);
        EditText datas = (EditText)findViewById(R.id.editText6);
        String modo = pagamentoParent.getItemAtPosition(pagamentoPosition).toString().trim();
        String categoria = categoriaParent.getItemAtPosition(categoriaPosition).toString().trim();
        String data = datas.getText().toString().trim();
        ValidaData validator = new ValidaData();
        if(!validator.isValid(data)){
            Toast.makeText(this,"Data Invalida!",Toast.LENGTH_SHORT).show();
        }
        else{
            data = validator.getDateValid(data);
            Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
        }

        String val = valor.getText().toString().trim();
        String name = nome.getText().toString().trim();
        if(!val.matches("") && !name.matches("")){
            Double salario = Double.parseDouble(val);
            boolean t =true;
            String a = "";
            int j;
            for(j=0; j < name.length();j++){
                char c = name.charAt(j);
                if((c > 32 && c < 65) || (c > 90 && c < 97) || (c > 122 && c < 127)){
                    a+= c;
                    t = false;
                }
            }
            if(t && j == name.length() && salario > 0){
                if(a2.isChecked()){
                    salario*= -1;
                }
                Financas novo = new Financas(categoria,"nada",a3.isChecked(),data,modo,salario);
                financas.add(novo);
                Toast.makeText(this,"Valor Adicionado",Toast.LENGTH_SHORT).show();
                Intent change = new Intent(this,MainActivity.class);
                startActivity(change);
            }
            else{
                if(!t){
                    Toast.makeText(this,"Caracteres "+a+" Invalidos!",Toast.LENGTH_SHORT).show();
                }
                else if(salario < 1){
                    Toast.makeText(this,"Salario Menor ou igual a 0",Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if(name.matches("")){
            Toast.makeText(this,"Nenhum valor escrito em Nome! ",Toast.LENGTH_SHORT).show();
        }
        else if(val.matches("")){
            Toast.makeText(this,"Nenhum valor escrito em Salario! ",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrar_financas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
