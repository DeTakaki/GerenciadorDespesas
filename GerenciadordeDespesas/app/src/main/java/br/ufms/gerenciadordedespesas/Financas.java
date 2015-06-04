package escobar.gabriel.engsoftware;

/**
 * Created by Gabriel on 27/05/2015.
 */
public class Financas{

    String categoria;
    String descricao;
    boolean eventoPrevisto;
    String data;
    String modoPagamento;
    double valor;


    public Financas(String categoria, String descricao, boolean eventoPrevisto, String data, String modoPagamento, double valor) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.eventoPrevisto = eventoPrevisto;
        this.data = data;
        this.modoPagamento = modoPagamento;
        this.valor = valor;

        Usuario.changeSalario(valor);

    }



    /***********************************/

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
