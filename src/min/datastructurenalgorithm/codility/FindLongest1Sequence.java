package min.datastructurenalgorithm.codility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindLongest1Sequence {
    public static void main(String args[]) {
        FindLongest1Sequence tes = new FindLongest1Sequence();
        tes.solution(111001);
    }

    public int solution(int X) {
        int result = 0;

        String origin = X + "";
        String pattern = "1[1|0]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(origin);
        if (m.find()) {
            //origin
            result = find(origin);
        } else {
            StringBuilder input = new StringBuilder();
            int i = 0;
            while (X > 0) {
                input.append(X % 2);
                i++;
                X = X / 2;
            }
            input = input.reverse();
            result = find(input.toString());
        }


        return result;
    }

    public int find(String s) {
        int count = 0;
        String[] converted = s.split("");


        List<String[]> ls = new ArrayList<String[]>();
        String[] tmp = new String [s.length()];
        for (int j = 0; j < converted.length; j++) {
            tmp[j] = converted[j];
            if (converted[j].equals("0")) {
                tmp[j] = "1";
                ls.add(tmp);
                tmp = null;
            }
        }
        int max = 0;
        for (int j = 0; j < ls.size(); j++) {
            for (int k = 0; k < ls.get(j).length; k++) {
                if (ls.get(j)[k] == "1") {
                    max = max + 1;
                } else {
                    if (count < max) {
                        count = max;
                    }
                    max = 0;
                }
            }
        }
        System.out.print(count);
        return count;
    }
}
