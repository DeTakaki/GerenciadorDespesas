package escobar.gabriel.engsoftware;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ConsultarFinancas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_financas);
        consultarFinancas();

    }

    private void consultarFinancas(){
        TextView saldo = (TextView)findViewById(R.id.textView8);
        TextView receita = (TextView)findViewById(R.id.textView9);
        TextView despesa = (TextView)findViewById(R.id.textView10);
        TextView disponivel = (TextView)findViewById(R.id.textView12);

        saldo.setText("R$ "+Usuario.salario);

        receita.setText("R$ " + Usuario.receita);

        despesa.setText("R$ " + Usuario.despesa);

        disponivel.setText("R$ "+Usuario.saldo);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_financas, menu);
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
