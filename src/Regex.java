import java.util.regex.Matcher;
import java.util.regex.Pattern;


    public class Regex {


        public static boolean isTextFieldValid(TextFeilds textField, String text) {
            String field = "";
            switch (textField) {
                case ELECTRONIC_ID:
                    field = "^E\\d{3}$";
                    break;
                case CLOTHING_ID:
                    field = "^C\\d{3}$";
                    break;
                case STRING_VALUES:
                    field = "^[A-z|\\s]{3,}$";
                    break;
                case NUMBERS:
                    field = "^([0-9]){1,}$";
                    break;
                case PRICE:
                    field = "^\\d+(\\.\\d{1,2})?$";
                    break;
                case WARRENTY:
                    field = "^[A-Za-z0-9\\s\\-_]+$";
            }

            Pattern pattern = Pattern.compile(field);
            if (text != null) {
                if (text.trim().isEmpty()) {
                    return false;
                }
            } else {
                return false;
            }
            Matcher matcher = pattern.matcher(text);

            if (matcher.matches()) {
                return true;
            }
            return false;
}
    }

