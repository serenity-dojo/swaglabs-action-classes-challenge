package swaglabs.features.authentication;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import swaglabs.actions.authentication.LoginActions;
import swaglabs.actions.common.PageHeader;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Steps
    LoginActions login;

    PageHeader pageHeader;

    @Test
    public void withValidCredentials() {
        login.withCredentials("standard_user","secret_sauce");

        assertThat(pageHeader.title()).isEqualToIgnoringCase("Products");
    }
}
