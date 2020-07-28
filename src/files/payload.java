package files;

public class payload {
	
	public static String missingParameter() {
	return "{\r\n" + 
			"	\"username\":\"\",\r\n" + 
			"	\"password\":\"kickdrum\"\r\n" + 
			"}\r\n" + 
			"";

}
	
	public static String loginSuccess() {
		return "{\r\n" + 
				"	\"username\":\"kickdrum\",\r\n" + 
				"	\"password\":\"kickdrum\"\r\n" + 
				"}\r\n" + 
				"";
	}
	public static String InvalidCredential() {
		return "{\r\n" + 
				"	\"username\":\"kickdrum123\",\r\n" + 
				"	\"password\":\"kickdrum\"\r\n" + 
				"}\r\n" + 
				"";

	
}
}
