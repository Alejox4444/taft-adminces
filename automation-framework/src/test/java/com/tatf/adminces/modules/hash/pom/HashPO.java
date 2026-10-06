package com.tatf.adminces.modules.hash.pom;

import com.tatf.core.browser.IBrowser;

public class HashPO {
    private final IBrowser browser;

    private final String hashInput = "input[type='password']";
    private final String hashSubmitButton = "button[type='submit']";

    public HashPO(IBrowser browser) {
        this.browser = browser;
    }

    public void navigateTo(String url) {
        this.browser.interaction().navigateTo(url);
    }

    public void enterHash(String hash) {
        this.browser.find().css(hashInput).write(hash);
    }

    public void clickHashSubmitButton() {
        this.browser.find().css(hashSubmitButton).click();
    }
}