package com.siggy.training.code.smells.print;

public class PrintReport {
    private final String name;

    public PrintReport(String name) {
        this.name = name;
    }

    public void printOwing(double amount) {
        printBanner();
        //print details
        System.out.println("name: " + name);
        System.out.println("amount: " + amount);
    }

    public void printLateNotice(double amount) {
        printBanner();
        printLateNotice();
        //print details
        System.out.println("name: " + name);
        System.out.println("amount: " + amount);
    }

    private void printBanner() {
        System.out.println("********************************************");
        System.out.println("**           Amount Owed                  **");
        System.out.println("********************************************");
    }

    private void printLateNotice() {
        System.out.println("**           LATE NOTICE                  **");
        System.out.println("********************************************");
    }

    public static void main(String[] args) {
        new PrintReport("Joe").printOwing(25.50);
        new PrintReport("Rochelle").printLateNotice(4.73);
    }
}
