package escobar.gabriel.engsoftware;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class Categorias extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);


        if(getIntent().hasExtra("categoria")){
            String categoria = getIntent().getExtras().getString("categoria");
            RegistrarFinancas.categorias.add(categoria);
            Toast.makeText(this,"Categoria "+categoria+" adicionada",Toast.LENGTH_SHORT).show();
        }
        if(getIntent().hasExtra("position")){

            int pos = getIntent().getExtras().getInt("position");
            if(pos != 0){
                String name = RegistrarFinancas.categorias.get(pos);
                RegistrarFinancas.categorias.remove(pos);
                Toast.makeText(this,"Categoria "+name+" removida",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categorias, menu);
        return true;
    }
    public void onClickInserirCategoria(View view){
        Intent intent = new Intent(this,InserirCategoria.class);
        startActivity(intent);
    }

    public void onClickButtonExcluirCategoria(View view){
        Intent intent = new Intent(this,ExcluirCategorias.class);
        startActivity(intent);
    }

    public void onClickButtonVoltar(View v){

       Intent a = new Intent(this,RegistrarFinancas.class);
        startActivity(a);

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
