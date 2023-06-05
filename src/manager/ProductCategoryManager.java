package manager;

import model.Product;
import model.ProductComparator;
import model.ProductComparatorForDesc;

import java.util.Collections;
import java.util.List;

public class ProductCategoryManager {

    public void productViewAscending(List<Product> products) {
        Collections.sort(products, new ProductComparator());
    }

    public void productViewDescending(List<Product> products) {
        Collections.sort(products, new ProductComparatorForDesc());
    }
}
