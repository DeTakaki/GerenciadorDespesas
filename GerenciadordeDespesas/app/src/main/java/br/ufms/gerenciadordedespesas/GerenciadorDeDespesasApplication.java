package br.ufms.gerenciadordedespesas;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by Diego on 6/18/2015.
 */
public class GerenciadorDeDespesasApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
