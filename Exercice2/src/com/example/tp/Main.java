package com.example.tp;

public class Main {
    public static void main(String[] args) {
        NotificationManager centre = new NotificationManager();

        centre.addChannel(new EmailNotification("atelier@campus.ma"));
        centre.addChannel(new PushNotification("ma.campus.ouiam"));
        centre.addChannel(new SMSNotification("CampusJava"));
        centre.addChannel(new EmailNotification("rappels@campus.ma"));

        centre.broadcast("ouiam.elmotfi@example.com",
                "Votre atelier Java commence a 14 h.");
        centre.broadcast("groupe-tp8",
                "Le compte rendu est disponible dans votre espace.");
    }
}
