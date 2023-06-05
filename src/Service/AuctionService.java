package Service;

import common.InputHandler;
import model.Auction;

public class AuctionService {
    public Auction doCheckAuctionDeatils() {
        Auction auction = new Auction();
        System.out.println("Enter auction id");
        auction.setAuctionId(InputHandler.takeNumberInput());
        return auction;
    }
}
