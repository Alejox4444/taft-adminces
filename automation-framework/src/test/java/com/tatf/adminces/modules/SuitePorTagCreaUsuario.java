package com.tatf.adminces.modules;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite tests que crean Usuarios")
@SelectPackages({"com.tatf.adminces.modules.home.test"})
@IncludeTags({"CreaUsuario"})
public class SuitePorTagCreaUsuario {

}
