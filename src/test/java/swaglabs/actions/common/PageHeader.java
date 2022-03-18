package swaglabs.actions.common;

import net.serenitybdd.core.pages.PageComponent;

public class PageHeader extends PageComponent {
    public String title() {
        return $(".title").getText();
    }
}
