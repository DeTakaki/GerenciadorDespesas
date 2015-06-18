package br.ufms.gerenciadordedespesas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TesteCons extends ActionBarActivity {

    RadioButton val,cat;
    static ArrayList<Financas> filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_cons);
        completar();
        val = (RadioButton)findViewById(R.id.radioButton5);
        cat = (RadioButton)findViewById(R.id.radioButton6);

        val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cat.setChecked(false);
                EditText ini = (EditText) findViewById(R.id.editText8);
                EditText fim = (EditText) findViewById(R.id.editText9);
                EditText cate = (EditText) findViewById(R.id.editText10);
                ini.setVisibility(View.VISIBLE);
                fim.setVisibility(View.VISIBLE);
                cate.setVisibility(View.INVISIBLE);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val.setChecked(false);
                EditText ini = (EditText) findViewById(R.id.editText8);
                EditText fim = (EditText) findViewById(R.id.editText9);
                EditText cate = (EditText) findViewById(R.id.editText10);
                ini.setVisibility(View.INVISIBLE);
                fim.setVisibility(View.INVISIBLE);
                cate.setVisibility(View.VISIBLE);
            }
        });

    }

    public void completar(){
        TextView saldo = (TextView)findViewById(R.id.textView17);
        TextView receita = (TextView)findViewById(R.id.textView18);
        TextView despesa = (TextView)findViewById(R.id.textView19);
        TextView disponivel = (TextView)findViewById(R.id.textView20);

        RadioButton a = (RadioButton)findViewById(R.id.radioButton5);
        a.setChecked(true);
        EditText b = (EditText)findViewById(R.id.editText8);
        EditText c = (EditText)findViewById(R.id.editText9);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);

        saldo.setText("R$ "+Usuario.salario);

        receita.setText("R$ " + Usuario.receita);

        despesa.setText("R$ " + Usuario.despesa);

        disponivel.setText("R$ " + Usuario.saldo);
    }



    public void visualizar(View v){
        filter = new ArrayList<Financas>();
        RadioButton valor = (RadioButton)findViewById(R.id.radioButton5);
        if(valor.isChecked()){
            EditText saldoIni = (EditText)findViewById(R.id.editText8);
            EditText saldoFim = (EditText)findViewById(R.id.editText9);

            if(saldoIni.getText().toString().trim().matches("") || saldoFim.getText().toString().trim().matches("")){
                Toast.makeText(this,"Valores Invalidos",Toast.LENGTH_SHORT).show();
            }
            else{

                double valorI = Double.parseDouble(saldoIni.getText().toString().trim());
                double valorF = Double.parseDouble(saldoFim.getText().toString().trim());
                if(valorF < valorI){
                    double a = valorF;
                    valorF = valorI;
                    valorI = a;
                }
                filter = valores(valorI,valorF);
                if(filter.size() == 0){
                    Toast.makeText(this,"Nao ha valores nesse intervalo",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent boa = new Intent(this,MostrarDados.class);
                    startActivity(boa);
                }
            }

        }
        else{
            /* categoria */
            EditText cat = (EditText)findViewById(R.id.editText10);
            String categoria = cat.getText().toString().trim();
            filter = categorias(categoria);
            if(filter.size() == 0){
                Toast.makeText(this,"Nao ha valores nessa categoria",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent boa = new Intent(this,MostrarDados.class);
                startActivity(boa);
            }
        }
    }
    public ArrayList<Financas> valores(double inicio,double fim){
        ArrayList<Financas> val = new ArrayList<Financas>();

        for(int i=0; i< RegistrarFinancas.financas.size(); i++){
            if(RegistrarFinancas.financas.get(i).valor >= inicio && RegistrarFinancas.financas.get(i).valor <= fim
                    || RegistrarFinancas.financas.get(i).valor >= -fim && RegistrarFinancas.financas.get(i).valor <= -inicio ){
                val.add(RegistrarFinancas.financas.get(i));
            }
        }
        return val;
    }

    public ArrayList<Financas> categorias(String cat){
        ArrayList<Financas> cate = new ArrayList<Financas>();

        for(int i=0; i < RegistrarFinancas.financas.size();i++){
            if(RegistrarFinancas.financas.get(i).getCategoria().equals(cat)){
                cate.add(RegistrarFinancas.financas.get(i));
            }
        }

        return cate;
    }

    public void cancelar(View v){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teste_cons, menu);
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
