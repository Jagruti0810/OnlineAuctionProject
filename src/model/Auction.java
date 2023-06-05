package model;

public class Auction {

    private String title;
    private double minimumBidPrice;
    private int productId;
    private String startDate;
    private String endDate;
    private int auctionId;
    private int sellerId;

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public Auction(int auctionId, String title, int minimumBidPrice) {
        this.auctionId = auctionId;
        this.title = title;
        this.minimumBidPrice = minimumBidPrice;

    }

    public Auction() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMinimumBidPrice() {
        return minimumBidPrice;
    }

    public void setMinimumBidPrice(double minimumBidPrice) {
        this.minimumBidPrice = minimumBidPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
