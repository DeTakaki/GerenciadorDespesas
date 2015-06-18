package br.ufms.gerenciadordedespesas;

/**
 * Created by Gabriel on 26/05/2015.
 */
public class Usuario {
    String nome;
    static Double salario;
    static boolean user = false;

    public String getNome(){
        return  nome;
    }
    public Double getSalario() {
        return salario;
    }
    public static void changeSalario(Double a){
        salario+= a;
    }

    public void Usuario(String nome, Double sal){
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
