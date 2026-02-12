package model.entities;

import model.exceptions.BusinessException;

public class Account {
    //numero conta.
    private Integer number;
    //titular conta.
    private String holder;
    //saldo conta.
    private Double balance;
    //limite de saque conta.
    private Double withdrawLimit;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    // Operação de deposito
    public void deposit(double amount) {
        balance += amount;
    }
    //Operação de saque
    public void withdraw(double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    // verifica se pode ser sacado com base no valor disponivel, se não lança uma exceção.
    private void validateWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Erro de saque: a quantia excede o limite de saque! ");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Erro de saque: Saldo insuficiente");
        }
    }
}
