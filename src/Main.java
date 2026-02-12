import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //invoca a linguagem e o Scanner
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Lê os dados do user
        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        //instancia de uma conta
        Account acc1 = new Account(number, holder, balance, withdrawLimit);
        //Lê os a qauntia de saque.
        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        //try-catch para capturar exceções.
        try {
            acc1.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc1.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        // fecha o Scanner 
        sc.close();



    }
}
