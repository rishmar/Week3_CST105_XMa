package Piglatin;

/**Author: Xinrui Ma
 * File:Piglatin.java
 * Date:2018.3.11
 * Summary: Translating file into Piglatin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Piglatin {

	static String fileText = "";
	static String[] textArray;
	// read the file
	static String fileLocation = "/Users/Rishmar/Desktop/Pig.txt";
	static int maxCharCount = new Integer(0);

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
			String readLine;
			while ((readLine = bufferedReader.readLine()) != null) {
				if (readLine.trim().isEmpty()) {
					continue;
				}
				fileText += readLine.trim();
			}
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
			System.exit(0);
		}
		LoadArray();
		parsePigLatin();
	}

	private static void LoadArray() {
		textArray = fileText.split(" ");
		for (int i = 0; i < textArray.length; i++) {
			if (textArray[i].length() > maxCharCount) {
				maxCharCount = textArray[i].length();
			}
		}
	}

	private static void parsePigLatin() {
		Pattern pattern = Pattern.compile("([a-z]+)([aeiou][a-z]+)");
		String outputFormat = "%-" + Integer.toString(maxCharCount) + "s    %-5s%n";
		for (int i = 0; i < textArray.length; i++) {
			Matcher matcher = pattern.matcher(textArray[i]);

			if (matcher.find()) {
				System.out.format(outputFormat, textArray[i],
						(matcher.group(2) + matcher.group(1) + "ay").toUpperCase());
			} else {
				System.out.format(outputFormat, textArray[i], (textArray[i] + "way").toUpperCase());
			}
		}
	}
}