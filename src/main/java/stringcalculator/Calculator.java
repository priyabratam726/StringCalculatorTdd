package stringcalculator;

public class Calculator {

	public static int add(String sText){
		if(sText.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(sText.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(sText.charAt(2));
				sText = sText.substring(4);
			}
			
			String textList[] = splitText(sText, delimiter + "|\n");
			return sum(textList);
		}
	}
	

	private static String[] splitText(String numbers, String divider){
	    return numbers.split(divider);
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInt(number) < 1000)
		    	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}