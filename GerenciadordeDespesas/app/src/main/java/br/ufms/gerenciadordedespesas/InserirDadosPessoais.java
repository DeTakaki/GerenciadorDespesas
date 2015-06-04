package escobar.gabriel.engsoftware;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class InserirDadosPessoais extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados_pessoais);
    }

    public void onClickSalvar(View v){
        EditText nome = (EditText)findViewById(R.id.editText2);
        EditText value = (EditText)findViewById(R.id.editText3);
        String val = value.getText().toString().trim();
        String name = nome.getText().toString().trim();
        if(!val.matches("") && !name.matches("")){
            Double salario = Double.parseDouble(value.getText().toString().trim());
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
                Intent muda = new Intent(this,MainActivity.class);
                MainActivity.usuario.Usuario(name,salario);
                Toast.makeText(this,"Dados de usuario Salvos!",Toast.LENGTH_SHORT);
                startActivity(muda);
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
    public void onClickVoltar(View v){
        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inserir_dados_pessoais, menu);
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
