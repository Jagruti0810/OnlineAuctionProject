package manager;

import Service.AuctionService;
import common.Session;
import dao.AuctionDao;
import dao.ProductDao;
import exception.DaoException;
import model.Auction;
import model.Product;
import view.AddProduct;
import view.AuctionView;

import java.util.List;

public class AuctionManager {
    private AuctionDao auctionDao = new AuctionDao();
    private ProductDao productDao = new ProductDao();
    private AuctionView auctionView = new AuctionView();

    //addAuctionDetails
    public void addAuction() throws DaoException {
        List<Product> products = productDao.showProducts(Session.getCurrentUser().getUserId());
        AddProduct addProduct = new AddProduct();
        addProduct.displayProducts(products);
        Auction auction = auctionView.addAuctionInfo();
        auctionDao.addAuctionDetails(Session.getCurrentUser().getUserId(), auction);
    }

    public void viewAuctionDetails() throws DaoException {
        List<Auction> auction = auctionDao.getAuction(Session.getCurrentUser().getUserId());
        auctionView.displayAuctions(auction);
        AuctionService auctionService = new AuctionService();
        Auction auction1 = auctionService.doCheckAuctionDeatils();
        Auction auction2 = auctionDao.showAuctionDetails(auction1.getAuctionId());
        auctionView.displayAuctionsDeatils(auction2);
    }
    //viewAuctionAllDetails
//    public Auction getAuctionDetails() throws DaoException {
//        AuctionService auctionService = new AuctionService();
//        Auction auction1 = auctionService.doCheckAuctionDeatils();
//        Auction auction = auctionDao.showAuctionDetails(auction1.getAuctionId());
//        AuctionView auctionView = new AuctionView();
//        auctionView.displayAuctionsDeatils(auction);
//        return auction;
//    }
}

