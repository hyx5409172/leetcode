package topic;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(judge(21120));



    }

    public static boolean judge(int x){
        int orinum = x;
        int vernum = 0;
        while(x > 0){
            vernum = vernum * 10 + x % 10;
            x = x / 10;
//            if(x == vernum){
//                return true;
//            }
        }
        if(orinum == vernum){
            return true;
        } else {
            return false;
        }
    }


}
