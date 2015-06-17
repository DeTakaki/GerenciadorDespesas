package escobar.gabriel.engsoftware;

/**
 * Created by Gabriel on 27/05/2015.
 */
public class Financas{

    String nome;
    String categoria;
    int parcela;
    boolean eventoPrevisto;
    String data;
    String modoPagamento;
    double valor;


    public Financas(String nome,String categoria, boolean eventoPrevisto, String data, String modoPagamento, double valor,int parcela) {
        this.categoria = categoria;
        this.nome = nome;
        this.eventoPrevisto = eventoPrevisto;
        this.data = data;
        this.modoPagamento = modoPagamento;
        this.valor = valor;
        this.parcela = parcela;
        if(!eventoPrevisto)
            MainActivity.usuario.changeSalario(valor);
    }



    /***********************************/

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEventoPrevisto() {
        return eventoPrevisto;
    }

    public void setEventoPrevisto(boolean eventoPrevisto) {
        this.eventoPrevisto = eventoPrevisto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString(){
        return nome;
    }
}
