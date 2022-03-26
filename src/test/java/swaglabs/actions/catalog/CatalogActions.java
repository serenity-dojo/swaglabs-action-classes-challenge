package swaglabs.actions.catalog;

import net.serenitybdd.core.steps.UIInteractions;

import java.util.List;

public class CatalogActions  extends UIInteractions {

    public List<String> productTitles() {
        return $$(".inventory_item_name").texts();
    }

    public List<String> productImages() {
        return $$("img.inventory_item_img").map(img -> img.getAttribute("src"));
    }

    public List<ProductInfo> products() {
        return $$(".inventory_item_description")
                .map(item -> {
                   String title = item.findBy(".inventory_item_name").getText();
                   String description = item.findBy(".inventory_item_desc").getText();
                   double price = Double.parseDouble(item.findBy(".inventory_item_price").getText().replace("$",""));
                   return new ProductInfo(title, description, price);
                });
    }
}
