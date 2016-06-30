package common;

import org.testng.annotations.DataProvider;


public class DataproviderClass {
	@DataProvider(name="SearchProvider")
	public  static Object[][]  getDataFromDataprovider(){
		return new Object[][] { 
				{ "Guru99", "India" }, 
				{ "Krishna", "UK" }, 
				{ "Bhupesh", "USA" } 
			};
     }
	
	@DataProvider(name="MyHierarchyTest")
	public  static Object[][]  getLogins(){
		return new Object[][] { 
				{"bent.haugen@optimera.no","123456"},  
				{"optilag","inlag09"}     				
	//			{"itella","byggmakker"}
			};
     }
	
	@DataProvider(name="SDSManufacturer")
	public  static Object[][]  getSDSManufacturer(){
		return new Object[][] { 
				{"Bay91126","uzxgU3LR"}  
			};
     }
	
	@DataProvider(name="SDSQA")
	public  static Object[][]  getSDSQA(){
		return new Object[][] { 
				{"EssenticQA","E$$ent1cQA"}  
			};
     }
	
	@DataProvider(name="SDSPuncher")
	public  static Object[][]  getSDSPuncher(){
		return new Object[][] { 
				{"HMS97605","jzvsI7MB"}  
			};
     }
	
}
