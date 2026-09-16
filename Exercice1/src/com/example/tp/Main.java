package com.example.tp;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor caisse = new PaymentProcessor();

        caisse.addMethod(new CreditCard("4509-2100-6734-8821", "Ouiam Elmotfi", 680));
        caisse.addMethod(new PayPal("ouiam.etudes@example.com", 310));
        caisse.addMethod(new Bitcoin("bc1q-ouiam-lab", 0.075));
        caisse.addMethod(new CreditCard("5391-8004-1297-0042", "Meryem Ait Lahcen", 95));

        caisse.processPayments(120);
    }
}
