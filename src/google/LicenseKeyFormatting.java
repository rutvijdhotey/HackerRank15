package google;

public class LicenseKeyFormatting {
	
	public static String licenseKey(String s, int k){
		StringBuilder ans = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) != '-'){
				ans.append(ans.length() % (k + 1) == 0 ? "-":"").append(s.charAt(i));
			}
		}
		if(ans.length() != 0){
			if(ans.charAt(0) == '-') ans.deleteCharAt(0);
		}
		
		return ans.reverse().toString().toUpperCase();
	}
}
