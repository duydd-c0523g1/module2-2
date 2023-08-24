package extra.bai19;

import java.util.regex.Pattern;

public class RegEx {
    public static boolean validate(String string) {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        return pattern.matcher(string).matches();
    }
}
//Valid Forms:
//username@domain.com
//user.name@domain.com
//user-name@domain.com
//username@domain.co.in
//user_name@domain.com

//Invalid Forms:
//username.@domain.com
//.user.name@domain.com
//user-name@domain.com.
//username@.com