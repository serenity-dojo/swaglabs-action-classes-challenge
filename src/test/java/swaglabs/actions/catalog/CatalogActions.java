package swaglabs.actions.catalog;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

import java.util.List;

public class CatalogActions  extends UIInteractions {

    public List<String> productTitles() {
        return findAll(".inventory_item_name").texts();
    }

    public List<ProductInfo> products() {
        return findAll(".inventory_item")
                .map(item -> {
                   String title = item.findBy(".inventory_item_name").getText();
                   String description = item.findBy(".inventory_item_desc").getText();
                   String image = item.find(By.tagName("img")).getAttribute("src");
                   double price = Double.parseDouble(item.findBy(".inventory_item_price").getText().replace("$",""));

                   return new ProductInfo(title, description, price, image);
                });
    }
}
