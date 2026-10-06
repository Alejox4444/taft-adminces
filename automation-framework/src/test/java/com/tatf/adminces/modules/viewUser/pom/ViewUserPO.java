package com.tatf.adminces.modules.viewUser.pom;

import com.tatf.core.browser.IBrowser;

public class ViewUserPO {
    private final IBrowser browser;

    private final String viewUsersLink = "a[href='/adminces/view-users']";
    private final String yesButton = "//button[contains(text(),'Sí')]";

    public ViewUserPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickViewUsersLink() {
        this.browser.find().css(viewUsersLink).click();
    }

    public void clickDeleteUser(String email) {
        this.browser.find().css("button[id='"+ email + "']").click();
    }

    public void clickYes() {
        this.browser.find().xpath(yesButton).click();
    }
}