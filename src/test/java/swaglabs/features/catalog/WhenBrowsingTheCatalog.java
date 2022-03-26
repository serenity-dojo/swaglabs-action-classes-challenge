package swaglabs.features.catalog;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swaglabs.actions.authentication.LoginActions;
import swaglabs.actions.catalog.CatalogActions;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenBrowsingTheCatalog {

    @Steps
    LoginActions login;

    @Steps
    CatalogActions catalog;

    @BeforeEach
    void login() {
        login.asAStandardUser();
    }

    @Test
    void shouldSeeAllInventoryProduct() {
        assertThat(catalog.productTitles()).contains(
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Onesie",
                "Sauce Labs Bike Light",
                "Sauce Labs Fleece Jacket",
                "Test.allTheThings() T-Shirt (Red)"
        );
    }

    @Test
    void eachProductShouldHaveADescriptionAndAPrice() {
        assertThat(catalog.products()).allMatch(
                item -> !item.description().isEmpty() && !item.title().isEmpty() && item.price() > 0
        );
    }

    @Test
    void eachProductShouldHaveADifferentImage() {
        assertThat(catalog.productImages()).doesNotHaveDuplicates();
    }

    @Test
    void productsCanBeSortedByDifferentCriteria() {

    }

}
