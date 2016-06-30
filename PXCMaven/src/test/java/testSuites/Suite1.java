package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.*;

@RunWith(Suite.class)
@SuiteClasses({
     WPLeftMenus.class,
	 OpenMainPages.class,
	 AllDashboardLinks.class,
	 TestUDWPLinks.class,
     WPDashboardFilters.class,
     TestInviteCompany.class,
     TestInviteWP.class,
     DistributeDocs.class,
     MyHierarchyMenus.class})
public class Suite1 {

	
}
