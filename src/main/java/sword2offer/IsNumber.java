package sword2offer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumber {

    public static void main(String[] args) {
        String s = "+3. ";

        System.out.println(nativeWay(s));
    }

    public static boolean nativeWay(String s){
        String reg = "\\s*([\\+-])?(\\d)*\\.?(\\d)*([Ee]([\\+-])?\\d+)?\\s*";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches() &&
                (matcher.group(2) != null || matcher.group(3) != null);
    }

}
