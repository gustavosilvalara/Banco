package teste;

import main.Banco;

public class teste {
    public static void main(String[] args) {
        Banco c1 = new Banco();
        c1.abrirConta();
        c1.depositar();
        c1.sacar();
        c1.pagarMensal();
        c1.extrato();
        c1.fecharConta();

    }
}
