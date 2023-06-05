package view;

import common.InputHandler;
import model.Auction;

import java.util.List;

public class AuctionView {

    public Auction addAuctionInfo() {
        Auction auction = new Auction();
        System.out.println("Add your product into auction");
        System.out.println("Enter product id");
        auction.setProductId(InputHandler.takeNumberInput());
        System.out.println("Enter auction title:");
        auction.setTitle(InputHandler.takeStringInput());
        System.out.println("Enter minimum bid price:");
        auction.setMinimumBidPrice(InputHandler.takeNumberInput());
        System.out.println("Enter start date (YYYY-MM-DD):");
        auction.setStartDate(InputHandler.takeStringInput());
        System.out.println("Enter end date (YYYY-MM-DD):");
        auction.setEndDate(InputHandler.takeStringInput());
        System.out.println("Auction created successfully!");
        return auction;
    }

    public void displayAuctions(List<Auction> auctions) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s|\n","Auction id", "title", "minimumBidPrice");
        System.out.println("---------------------------------------------------------------");
        for (Auction auction : auctions) {
            System.out.printf("|%-20s|%-20s|%-20s|\n", auction.getAuctionId(), auction.getTitle(), auction.getMinimumBidPrice());
        }
        System.out.println("----------------------------------------------------------------");
    }

    public void displayAuctionsDeatils(Auction auction) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "auction id",
                "title", "Product id", "minimumBidPrice", "startDate", "endDate", "Seller id");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", auction.getAuctionId(), auction.getTitle(),
                auction.getProductId(), auction.getMinimumBidPrice(), auction.getStartDate(), auction.getEndDate(),
                auction.getSellerId());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
