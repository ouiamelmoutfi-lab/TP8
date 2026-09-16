package com.example.tp;

public class PaymentProcessor {
    private PaymentMethod[] methods;
    private int count;

    public PaymentProcessor() {
        methods = new PaymentMethod[3];
        count = 0;
    }

    public void addMethod(PaymentMethod method) {
        if (count == methods.length) {
            PaymentMethod[] nouveauTableau = new PaymentMethod[methods.length * 2];
            System.arraycopy(methods, 0, nouveauTableau, 0, methods.length);
            methods = nouveauTableau;
        }
        methods[count++] = method;
    }

    public void processPayments(double amount) {
        System.out.printf("=== Traitement d'un montant de %.2f ===%n", amount);
        for (int i = 0; i < count; i++) {
            PaymentMethod method = methods[i];
            System.out.println("-> Via " + method.getName());
            if (method.pay(amount)) {
                method.refund(amount / 2);
            }
            System.out.println();
        }
    }
}
