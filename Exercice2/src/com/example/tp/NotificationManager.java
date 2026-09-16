package com.example.tp;

import java.util.Arrays;
import java.util.Comparator;

public class NotificationManager {
    private Notification[] channels;
    private int count;

    public NotificationManager() {
        channels = new Notification[3];
        count = 0;
    }

    public void addChannel(Notification notification) {
        if (count == channels.length) {
            Notification[] nouveauTableau = new Notification[channels.length * 2];
            System.arraycopy(channels, 0, nouveauTableau, 0, channels.length);
            channels = nouveauTableau;
        }
        channels[count++] = notification;
    }

    public void broadcast(String recipient, String message) {
        Notification[] copie = Arrays.copyOf(channels, count);
        Arrays.sort(copie,
                Comparator.comparingInt(Notification::getPriority).reversed());

        System.out.println("Diffusion vers " + recipient + " :");
        for (Notification notification : copie) {
            System.out.printf("Canal [%s, priorite=%d] : ",
                    notification.getType(), notification.getPriority());
            notification.send(recipient, message);
        }
        System.out.println();
    }
}
