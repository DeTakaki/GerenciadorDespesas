package escobar.gabriel.engsoftware;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public static Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickInserirDados(View v){
        if((usuario == null)){
            Intent a = new Intent(this,InserirDadosPessoais.class);
            startActivity(a);
        }
        else{
            Toast.makeText(this,"Ja existe um Usuario",Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickRegistrarFinancas(View v){
        if((usuario == null)){
            Toast.makeText(this,"E preciso cadastrar um usuario\nClique em inserir dados pessoais!",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent a = new Intent(this,RegistrarFinancas.class);
            startActivity(a);
        }
    }
    public void onClickConsultarFinancas(View v){
        if((usuario == null)){
            Toast.makeText(this,"E preciso cadastrar um usuario\nClique em inserir dados pessoais!",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent a = new Intent(this,TesteCons.class);
            startActivity(a);
        }
    }
    public void onClickAnalisarFinancas(View v){
        if((usuario == null)){
            Toast.makeText(this,"E preciso cadastrar um usuario\nClique em inserir dados pessoais!",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent a = new Intent(this,AnalisarFinancas.class);
            startActivity(a);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
