import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Collections;
import java.util.LinkedList;

public class graycodesarefun {
    String[] names;

    public graycodesarefun(String[] names) {
        this.names = names;
    }
    public static LinkedList<String> BRGC(int n){
        LinkedList<String> list = new LinkedList<String>();
        // base case
        if (n == 1) {
            list.add("0");
            list.add("1");
        } else {
            LinkedList<String> L1 = BRGC(n - 1);
            LinkedList<String> L2 = new LinkedList<>(L1);
            Collections.reverse(L2);
            for (int i = 0; i < L1.size(); i++) {
                L1.set(i, "0" + L1.get(i));
            }
            for (int j = 0; j < L2.size(); j++) {
                L2.set(j, "1" + L2.get(j));
            }
            list.addAll(L1);
            list.addAll(L2);
        }
        return list;
    }

    public String whoMoves(String current, String next) {
        for (int i = 0; i<names.length;i++) {
            if(current.charAt(i) != next.charAt(i)) {
                if(Character.getNumericValue(current.charAt(i)) == 1) {
                    return (names[i] + " out");
                } else {
                    return (names[i] + " in");
                }
            }
        }
        return "";
    }
    public String whoInPicture(String gcode) {
        String returnString = "";
        for (int i = 0; i < names.length; i++) {
            if (Character.getNumericValue(gcode.charAt(i)) == 1) {
                returnString += (names[i] + " ");
            }
        }
        return returnString;
    }

    public void run() {
        LinkedList<String> graycodes = BRGC(names.length);
        System.out.println("Index | Gray Code | Child(ren) in Photo     | Action");
        for (int i = 0; i < graycodes.size(); i++) {
            String currGC = graycodes.get(i);
            String whoin = whoInPicture(currGC);
            while (whoin.length()< 25) {
                whoin += " "; }

            if (i>0) {
                String prevGC = graycodes.get(i-1);
                System.out.println( i + "     | " +   currGC
                        + "     | " + whoin  + "  | " + whoMoves(prevGC, currGC));
            } else {
                System.out.println( i + "     | " +   currGC
                        + "     | " + whoin  + "  | " );
            }

            }

        }


}
