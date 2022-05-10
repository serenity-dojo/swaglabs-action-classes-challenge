package swaglabs.features.cart;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swaglabs.actions.authentication.LoginActions;
import swaglabs.actions.cart.CartActions;
import swaglabs.actions.cart.ShoppingCartIcon;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenAddingItemsToTheCart {

    // Action classes
    @Steps
    LoginActions login;

    @Steps
    CartActions cart;

    // Page Components
    ShoppingCartIcon shoppingCartIcon;

    @BeforeEach
    void login() {
        login.asAStandardUser();
    }

    @Test
    @DisplayName("the cart should initially be empty")
    void cartShouldInitiallyBeEmpty() {
        assertThat(shoppingCartIcon.itemCount()).isEmpty();
    }

    @Test
    @DisplayName("the item count should represent the number of items currently in the cart")
    void addingAnItemShouldUpdateTheItemCount() {
        cart.addItem("Sauce Labs Backpack");
        assertThat(shoppingCartIcon.itemCount()).isEqualTo("1");
    }
}
