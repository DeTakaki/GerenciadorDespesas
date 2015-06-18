package br.ufms.gerenciadordedespesas;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gabriel on 26/05/2015.
 */
@Table(name = "Usuario")
public class Usuario {

    @Column(name = "nome")
    String nome;
    @Column(name = "salario")
    static double salario;
    @Column(name = "saldo")
    static double saldo;
    @Column(name = "receita")
    static double receita;
    @Column(name = "despesa")
    static double despesa;
    @Column(name = "user")
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
