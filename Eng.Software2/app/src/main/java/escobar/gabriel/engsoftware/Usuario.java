package escobar.gabriel.engsoftware;

/**
 * Created by Gabriel on 26/05/2015.
 */
public class Usuario {
    String nome;
    static double salario;
    static double saldo;
    static double receita;
    static double despesa;
    static boolean user = false;


    public Usuario(String n, double sal){
        nome = n;
        salario = sal;
        saldo = sal;
    }

    public String getNome(){
        return  nome;
    }
    public double getSalario() {
        return salario;
    }
    public void changeSalario(double a){
        if(a > 0){
            receita+= a;
        }
        else{
            despesa+=a;
        }
        saldo+= a;
    }

    public void Usuario(String nome, double sal){
        this.nome = nome;
        this.salario = sal;
        this.user = true;
    }
    public Usuario(){
        this.user = false;
    }

    public boolean isUser(){
        return this.user;
    }
}
