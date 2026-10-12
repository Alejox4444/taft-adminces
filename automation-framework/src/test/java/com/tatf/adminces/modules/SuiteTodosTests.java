package com.tatf.adminces.modules;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite de todos los Tests")
@SelectPackages({"com.tatf.adminces.modules.home.test"})
public class SuiteTodosTests {

}
