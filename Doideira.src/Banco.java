import java.util.Random;
import java.util.Scanner;

public class Banco {
    public int numConta;
    protected String tipo ;
    private String dono;
    private double saldo;
    private boolean status;

    public Banco() {
        setStatus(false);
        setSaldo(0);
    }


    public void abrirConta(){
        Scanner n = new Scanner(System.in);
        Scanner t = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Qual seu nome? ");
        String nome = n.next();
        setDono(nome);
        while(true){
            System.out.println("Deseja abrir uma conta Corrente(cc) ou uma conta Poupança (cp)?");
            String r = t.next();
            if (r.equals("cc")){
                setStatus(true);
                setTipo("cc");
                setSaldo(50);
                setNumConta(ran.nextInt(10000) + 1);
                System.out.println("Conta corrente criada!!!");
                break;
            } else if (r.equals("cp")) {
                setStatus(true);
                setTipo("cp");
                setSaldo(150);
                setNumConta(ran.nextInt(10000)+1);
                System.out.println("Conta poupança criada!!!");
                break;
            }else {
                System.out.println("Erro!!! Por favor digite apenas \"cc\" ou \"cp\"");
            }
        }
    }

    public void fecharConta(){
        Scanner t = new Scanner(System.in);
        while(true){
            System.out.println("Deseja fechar a conta? ");
            String r = t.next();
            if (r.equals("sim") && getSaldo() == 0 && isStatus() == true){
                System.out.println("Conta fechada!!");
                setStatus(false);
                break;
            }else if (r.equals("sim") && getSaldo() > 0 && isStatus() == true){
                System.out.println("Necessario sacar o dinhero!!");
                break;
            } else if (r.equals("Sim") && getSaldo() < 0 && isStatus() == true) {
                System.out.println("Necessario regularizaçao dos debitos para fechar a conta!!");
            } else if (r.equals("sim") && getSaldo() == 0 && isStatus() == false){
                System.out.println("Necessario criar uma conta!!");
                break;
            }else if (r.equals("nao") && isStatus() == false){
                System.out.println("Necessario criar uma conta!!");
                break;
            } else if (r.equals("nao") && isStatus() == true) {
                System.out.println("Obrigado por continuar conosco!!");
                break;
            } else {
                System.out.println("Erro!! Por favor digite apenas \"sim\" ou \"nao\".");
            }
        }
    }

    public void depositar(){
        Scanner t = new Scanner(System.in);
        while(true) {
            System.out.println("O saldo atual é " + getSaldo());
            if (isStatus() == true) {
                System.out.print("Qual valor o senhor deseja depositar?\nR$");
                double r = t.nextDouble();
                this.saldo += r;
            }else if (isStatus() == false){
                System.out.println("Necessario criar uma conta!!");
                break;
            }
            System.out.println("Deseja depositar mais algum valor? ");
            String res = t.next();
            if (res.equals("sim")){

            }else if (res.equals("nao")){
                System.out.println("Redirecionando para a pagina principal!!");
                System.out.println("O saldo da conta é " + getSaldo());
                break;
            }else{
                System.out.println("Erro!! Digite apenas \"sim\" ou \"nao\".");
            }
        }
    }

    public void sacar(){
        Scanner t = new Scanner(System.in);
        if (isStatus() && getSaldo() < -1) {
            System.out.println("Necessario realizar o debito para realização do saque!!");
        } else if (isStatus() && getSaldo() == 0) {
            System.out.println("O senhor não tem saldo para sacar!!!");
        } else if (isStatus() == false) {
            System.out.println("Necessario abrir uma conta para sacar");
        }
        if ( isStatus() == true && getSaldo() > 0) {
            System.out.print("Saldo atual: "+ getSaldo() + "\nQual valor o senhor deseja sacar?\nR$");
            double r = t.nextDouble();
            while (true) {
                if (getSaldo() < r ) {
                    System.out.println("Saldo menor doque sera sacado!!!");
                    break;
                } else if (getSaldo() > 0) {
                    this.saldo -= r;
                    System.out.println("Saque realizado com sucesso!!!\nsaldo atual: " + getSaldo());
                    break;
                }
            }
        }
    }

    public void pagarMensal(){
        double cc = 12;
        double cp = 20;
        if (isStatus() == true) {
            if (getTipo() == "cc") {
                if (getSaldo() <= 11.99) {
                    System.out.println("Necessario depositar para realização da cobrança mensal de R$12,00!!!");
                } else if (getSaldo() >= 12) {
                    System.out.println("Pago a taxa mensal da Conta Corrente!!!");
                }
            } else if (getTipo() == "cp") {
                if ((getSaldo() <= 19.99)) {
                    System.out.println("Necessario depositar para realização da cobrança mensal de R$20,00!!!");
                } else if (getSaldo() >= 20) {
                    System.out.println("Pago a taxa mensal da Conta Poupança!!!");
                }
            }
        }else {
            System.out.println("Necessario abrir uma conta!!!");
        }
    }

    public void extrato(){
        System.out.println("O saldo é " + getSaldo());
        System.out.println("O dono é " + getDono());
        System.out.println("O numero da conta é " + getNumConta());
        System.out.println("O tipo de conta é " + getTipo());
        System.out.println("O Status da conta é " + isStatus());
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}