package escobar.gabriel.engsoftware;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MostrarDados extends ActionBarActivity {

    Spinner dado;
    ArrayAdapter<Financas> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dados);

        TextView nome = (TextView)findViewById(R.id.textView23);
        TextView valor = (TextView)findViewById(R.id.textView24);
        TextView data = (TextView)findViewById(R.id.textView25);
        TextView categoria = (TextView)findViewById(R.id.textView26);

        nome.setVisibility(View.INVISIBLE);
        valor.setVisibility(View.INVISIBLE);
        data.setVisibility(View.INVISIBLE);
        categoria.setVisibility(View.INVISIBLE);


        dado =(Spinner)findViewById(R.id.spinner4);
        adapter = new ArrayAdapter<Financas>(this,android.R.layout.simple_spinner_item,TesteCons.filter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dado.setAdapter(adapter);
        dado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView nome = (TextView)findViewById(R.id.textView23);
                TextView valor = (TextView)findViewById(R.id.textView24);
                TextView data = (TextView)findViewById(R.id.textView25);
                TextView categoria = (TextView)findViewById(R.id.textView26);

                nome.setVisibility(View.VISIBLE);
                valor.setVisibility(View.VISIBLE);
                data.setVisibility(View.VISIBLE);
                categoria.setVisibility(View.VISIBLE);

                nome.setText(TesteCons.filter.get(position).nome);
                valor.setText(TesteCons.filter.get(position).valor + "");
                data.setText(TesteCons.filter.get(position).data);
                categoria.setText(TesteCons.filter.get(position).categoria);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void voltar(View v){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_dados, menu);
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
