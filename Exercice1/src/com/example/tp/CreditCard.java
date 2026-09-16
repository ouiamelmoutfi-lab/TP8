package com.example.tp;

public class CreditCard implements PaymentMethod {
    private String number;
    private String holder;
    private double balance;

    public CreditCard(String number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.printf("Carte de %s : paiement %.2f DH refuse (solde %.2f DH)%n",
                    holder, amount, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("Carte de %s : paiement %.2f DH accepte, reste %.2f DH%n",
                holder, amount, balance);
        return true;
    }

    @Override
    public boolean refund(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        System.out.printf("Carte de %s : remboursement %.2f DH, solde %.2f DH%n",
                holder, amount, balance);
        return true;
    }

    @Override
    public String getName() {
        String finNumero = number.length() >= 4
                ? number.substring(number.length() - 4) : number;
        return "CreditCard[" + holder + ", ****" + finNumero + "]";
    }
}
