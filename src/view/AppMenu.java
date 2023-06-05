package view;

import common.InputHandler;

public class AppMenu {
    public static int displayMainMenu() {
        System.out.println("Please select from below choices:");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
        return InputHandler.takeNumberInput();
    }

    public void displayMainMenuAndSelect() {
        System.out.println("Please select from below choices:");
        System.out.println("1. Product Management");
        System.out.println("2. Auction Management");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
    }

    public void displayProductMenu() {
        System.out.println("1.Create product");
        System.out.println("2.View product");
        System.out.println("3.Update product");
        System.out.println("4.Delete product");
        System.out.println("5.Exit");
        System.out.println("Enter your Choice:");
    }

    public void displayAllProductDetails() {
        System.out.println("1.View ascending");
        System.out.println("2.View descending");
        System.out.println("Enter your Choice: ");
    }

    public void displayAuctionMenu() {
        System.out.println("1.Create Auction");
        System.out.println("2.View Auction");
        System.out.println("3.Update Auction");
        System.out.println("4.Delete Auction");
        System.out.println("5.Exit");
        System.out.println("Enter your Choice:");
    }
}
