import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
	public int add(String intput) {
		int kq=0;
		if(intput==null||intput.isEmpty())
			return 0;
		String intputToStandard=convertToStandardDelimiter(intput);
		kq=sumWithdelimiterDefaut(intputToStandard);
		return kq;
	}

	private String convertToStandardDelimiter(String convert) {
		String converted = convert;
		if(convert.startsWith("//")){
			Matcher matcher= Pattern.compile("\\[([^\\[]+)\\]").matcher(convert);
			while (matcher.find()){
				System.out.println(matcher.group(1));
				converted= converted.replaceAll(Pattern.quote(matcher.group(1)), ",");
			}
		}
		return converted;
	}

	private int sumWithdelimiterDefaut(String intputToStandard) {
		int kq=0;
		boolean flag=false;
		String negatives="negatives not allowed:";
		Matcher matcher= Pattern.compile("-?[0-9]+").matcher(intputToStandard);
		while (matcher.find()) {
			int temp=Integer.parseInt(matcher.group(0));
			if(temp<0){
				negatives+= flag ? ", "+temp : " "+temp;
				flag=true;
			}
			kq+= temp<1001? temp: 0;
		}
		if(flag)
			throw new RuntimeException(negatives);
		return kq;
	}

}
