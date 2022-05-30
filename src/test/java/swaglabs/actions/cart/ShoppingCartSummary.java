package swaglabs.actions.cart;

import net.serenitybdd.core.pages.PageComponent;

import java.util.List;

public class ShoppingCartSummary extends PageComponent {

    public List<String> itemTitles() {
        return findAll(".inventory_item_name").texts();
    }

    public List<ShoppingCartItem> items() {
        return findAll(".cart_item_label").map(
                itemSection -> {
                    String title = itemSection.findBy(".inventory_item_name").getText();
                    String description = itemSection.findBy(".inventory_item_desc").getText();
                    Double price = Double.parseDouble(itemSection.findBy(".inventory_item_price").getText().substring(1));
                    return new ShoppingCartItem(title,description, price);
                }
        );
    }
}
