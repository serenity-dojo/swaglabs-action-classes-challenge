package swaglabs.actions.cart;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
import net.thucydides.core.annotations.Step;

public class CartActions extends UIInteractions {

    @Step
    public void addItem(String itemName) {
        $(Button.withText("Add to cart")
                .inside(PageElement.containingText(".inventory_item",itemName)))
                .click();
    }

    public void viewCart() {
        $(".shopping_cart_link").click();
    }
}


