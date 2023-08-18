package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateFormatValidation {
    public static void main(String[] args) {
        String inputDate = "02282023"; // Example date in MMddYYYY format

        boolean isValid = isValidDateFormat(inputDate, "MMddyyyy");

        if (isValid) {
            String formattedDate = formatDate(inputDate, "MMddyyyy", "MMM dd yyyy");
            System.out.println("Date format is valid. Entered date in MMM dd yyyy pattern: " + formattedDate);
        } else {
            System.out.println("Date format is not valid.");
        }
    }

    public static boolean isValidDateFormat(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withResolverStyle(ResolverStyle.STRICT); // Set strict resolver style
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
        	e.printStackTrace();
            return false;
        }
    }

    public static String formatDate(String dateStr, String inputPattern, String outputPattern) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern);
        LocalDate date = LocalDate.parse(dateStr, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern);
        return date.format(outputFormatter);
    }
}

