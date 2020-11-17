package topic;

public class A925_isLongPressedName {

    public static void main(String[] args) {
        A925_isLongPressedName a925_isLongPressedName = new A925_isLongPressedName();
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        System.out.println(a925_isLongPressedName.isLongPressedName(name, typed));
    }

    public boolean isLongPressedName(String name, String typed) {
        if(name == typed){
            return  true;
        }

        if(name == null || typed == null){
            return false;
        }

        int nIndex = 0;
        int tIndex = 0;
        int nLength = name.length();
        int tLength = typed.length();

        for (;nIndex < nLength; nIndex ++, tIndex++){
            if(tIndex >= tLength){
//                // debug
//                System.out.println("tIndex out of bound, false!");
                return  false;
            }
//            // debug
//            System.out.println("nIndex: " + nIndex);
//            System.out.println("tIndex: " + tIndex);
            char nChar = name.charAt(nIndex);
            char tChar = typed.charAt(tIndex);
//            // debug
//            System.out.println("nChar: " + nChar);
//            System.out.println("tChar: " + tChar);
            if(nChar == tChar){
//                // debug
//                System.out.println("pass");
                continue;
            }

            if(tIndex > 0 && tChar == typed.charAt(tIndex - 1)){
                tIndex = toNextDifferChar(typed, tIndex);
                if(tIndex == tLength){
//                    // debug
//                    System.out.println("tIndex out of bound, false!");
                    return false;
                }
                tChar = typed.charAt(tIndex);
//                // debug
//                System.out.println("to next Index: " + tIndex);
//                System.out.println("new tChar: " + tChar);
                if(nChar == tChar){
//                    // debug
//                    System.out.println("pass");
                    continue;
                }
//                // debug
//                System.out.println("false");
                return false;
            } else {
//                // debug
//                System.out.println("false");
                return false;
            }

        }

        if(tIndex != tLength){
            tIndex = toNextDifferChar(typed, tIndex);
        }
        // debug
        System.out.println("finally ans: " + (tIndex == tLength));
        return tIndex == tLength;
    }

    public int toNextDifferChar(String str, int index){
        int length = str.length();
        char cha = str.charAt(index);
        while(index < length && str.charAt(index) == cha){
            index++;
        }

        return index;
    }

}
