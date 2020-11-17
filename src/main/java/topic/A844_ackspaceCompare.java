package topic;

/**
 * leetcode 844 ez
 * */
public class A844_ackspaceCompare {

    public static void main(String[] args) {
        A844_ackspaceCompare a = new A844_ackspaceCompare();
        String S = "ab#c";
        String T = "ad#c";

        System.out.println(a.backspaceCompare(S, T));

//        A844_ackspaceCompare s = new Asub();
//        System.out.println(s.getClass());
    }

//    static class Asub extends A844_ackspaceCompare {
//
//    }

    public boolean backspaceCompare(String S, String T) {
        if(S == T){
            return true;
        }

        if(S == null || T == null){
            return false;
        }

        S = genStr(S);
        T = genStr(T);

        return S.equals(T);
    }

    public String genStr(String str){
        StringBuilder sb = new StringBuilder(str);
        int index = sb.indexOf("#");
        while(index > -1){
            int length = index > 0? 2 : 1;
            sb.delete(index - length + 1, index + 1);
            index = sb.indexOf("#");
        }

        return sb.toString();
    }

}
