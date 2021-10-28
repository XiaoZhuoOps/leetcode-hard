package offer;

import java.util.regex.Pattern;

public class O20 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean ans = false;
        String p0 = "^";
        String p1 = "[+-]?";
        String p2 = "[.]{1}";
        String p3 = "[0-9]+";
        String p4 = "[Ee]{1}[+-]?[0-9]+";
        String p5 = "$";

        return (Pattern.matches(p0+p1+p3+p5, s) ||
        Pattern.matches(p0+p1+p3+p2+p3+p5, s) ||
        Pattern.matches(p0+p1+p3+p4+p5, s) ||
        Pattern.matches(p0+p1+p3+p2+p3+p4+p5, s) ||
        Pattern.matches(p0+p1+p2+p3+p5, s) ||
        Pattern.matches(p0+p1+p2+p3+p4+p5, s) ||
        Pattern.matches(p0+p1+p3+p2+p5, s) ||
        Pattern.matches(p0+p1+p3+p2+p4+p5, s)
        );
    }
}
