package utilities;

//again this could be only a function but created class for future command line reads

public class ReadCommandLineArguments {
	
	public static String browserName;
	public static String url;

	//reads browserName and url from mvn command line
	public static void readCMDArguments()
	{
		browserName = System.getProperty("browser");
		url = System.getProperty("url");
	}

}