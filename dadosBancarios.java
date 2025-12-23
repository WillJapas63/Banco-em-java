import java.io.*;
import java.util.*;

public class dadosBancarios {
    private static int proximoId = 1;
    public int id;
    public String name;
    private double saldo;
    private int senha;

    public dadosBancarios(String name, int senha) {
        this.id = proximoId++;
        this.name = name;
        this.saldo = 0;
        this.senha = senha;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("Valor insuficiente para depósito!");
        } else {
            saldo += valor;
        }
    }
    public void conferirSaldo(int password){
        if (password != senha){
            System.out.println("Acesso negado!");
        }else{
            System.out.println(saldo + "R$");
        }



    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<dadosBancarios> dados = new ArrayList<>();
        int opção;
        do{
            
        System.out.println("Bem vindo ao banco\n");
        System.out.println("1. Depositar");
        System.out.println("2. Ver contas");
        System.out.println("3. Ver saldo");
        System.out.println("Selecione a opção: \n");
        opção = Integer.parseInt(reader.readLine());
       

        switch (opção) {
            case 1:{
                
                System.out.println("Coloque um nome para depósito: ");
                String nome = reader.readLine();
                System.out.println("Coloque um valor para depósito: ");
                double valor = Double.parseDouble(reader.readLine());
                System.out.println("Registre uma senha!");
                int pass = Integer.parseInt(reader.readLine());
                System.out.println("Depósito realizado com sucesso!");
                System.out.println("\n");
                Thread.sleep(1000);

                dadosBancarios d = new dadosBancarios(nome, pass);
                d.depositar(valor);
                dados.add(d);
                
                break;
            }
            case 2:{
                for (dadosBancarios d : dados){
                    System.out.println("Id: " + d.id +"\n"
                        + "Nome: " + d.name);         
                }
                Thread.sleep(3000);
                break;}
            
            
            case 3:
                System.out.println("Selecione o ID da conta que você deseja acessar");
                int idInformado = Integer.parseInt(reader.readLine());
                
                dadosBancarios contaEncontrada = null;

                for (dadosBancarios d : dados){
                    if (d.id == idInformado) {
                        contaEncontrada = d;
                    }

                }

        }

    }while (opção != 6);
    }
}