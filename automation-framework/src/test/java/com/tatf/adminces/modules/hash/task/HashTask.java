package com.tatf.adminces.modules.hash.task;

import com.tatf.core.browser.IBrowser;
import com.tatf.adminces.modules.hash.data.HashData;
import com.tatf.adminces.modules.hash.pom.HashPO;

public class HashTask {
    private final IBrowser browser;
    private final HashPO hash;

    public HashTask(IBrowser browser) {
        this.browser = browser;
        this.hash = new HashPO(this.browser);
    }

    public void enterToSystem() {
        hash.navigateTo(HashData.url);
        hash.enterHash(HashData.hash);
        hash.clickHashSubmitButton();
    }

}