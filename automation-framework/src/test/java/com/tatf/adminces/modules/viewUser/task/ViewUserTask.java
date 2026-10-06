package com.tatf.adminces.modules.viewUser.task;

import com.tatf.adminces.modules.viewUser.data.ViewUserData;
import com.tatf.adminces.modules.viewUser.pom.ViewUserPO;
import com.tatf.core.browser.IBrowser;

public class ViewUserTask {
    private final IBrowser browser;
    private final ViewUserPO viewUser;

    public ViewUserTask(IBrowser browser) {
        this.browser = browser;
        this.viewUser = new ViewUserPO(this.browser);
    }

    public void deleteTester() {
        viewUser.clickViewUsersLink();
        viewUser.clickDeleteUser(ViewUserData.borrar);
        viewUser.clickYes();
    }
}