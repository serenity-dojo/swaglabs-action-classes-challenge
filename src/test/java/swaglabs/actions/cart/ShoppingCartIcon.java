package swaglabs.actions.cart;

import net.serenitybdd.core.pages.PageComponent;

public class ShoppingCartIcon extends PageComponent {
    public String itemCount() {
        return $(".shopping_cart_link").getText();
    }
}
