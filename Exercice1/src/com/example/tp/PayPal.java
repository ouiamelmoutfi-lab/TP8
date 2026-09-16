package com.example.tp;

public class PayPal implements PaymentMethod {
    private String email;
    private double balance;

    public PayPal(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.printf("PayPal %s : paiement %.2f DH refuse (solde %.2f DH)%n",
                    email, amount, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("PayPal %s : paiement %.2f DH accepte, reste %.2f DH%n",
                email, amount, balance);
        return true;
    }

    @Override
    public boolean refund(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        System.out.printf("PayPal %s : remboursement %.2f DH, solde %.2f DH%n",
                email, amount, balance);
        return true;
    }

    @Override
    public String getName() {
        return "PayPal[" + email + "]";
    }
}
