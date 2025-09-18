public class InputValidator {

    // Validate date in mm/dd/yyyy format with proper month/day checks
    public static boolean isValidDate(String date) {
        if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;

      
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;

        
        if (month == 2) {
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if ((leap && day > 29) || (!leap && day > 28)) return false;
        }

        return true; 
    }
}
