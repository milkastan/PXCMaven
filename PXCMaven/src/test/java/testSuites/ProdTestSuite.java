package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.ProdDashboardLinks;
import tests.ProdMyHierarchyMenus;
import tests.ProdOpenMainPages;
import tests.ProdUDWPLinks;
import tests.ProdWPLeftMenus;

@RunWith(Suite.class)
@SuiteClasses({ 
	ProdDashboardLinks.class, 
	ProdOpenMainPages.class, 
	ProdUDWPLinks.class,
	ProdMyHierarchyMenus.class,
	ProdWPLeftMenus.class})

public class ProdTestSuite {

}
