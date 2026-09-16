package com.example.tp;

public class Bitcoin implements PaymentMethod {
    private String walletAddress;
    private double balance;

    public Bitcoin(String walletAddress, double balance) {
        this.walletAddress = walletAddress;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.printf("Bitcoin %s : paiement %.4f BTC refuse (solde %.4f BTC)%n",
                    walletAddress, amount, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("Bitcoin %s : paiement %.4f BTC accepte, reste %.4f BTC%n",
                walletAddress, amount, balance);
        return true;
    }

    @Override
    public boolean refund(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        System.out.printf("Bitcoin %s : remboursement %.4f BTC, solde %.4f BTC%n",
                walletAddress, amount, balance);
        return true;
    }

    @Override
    public String getName() {
        return "Bitcoin[" + walletAddress + "]";
    }
}
