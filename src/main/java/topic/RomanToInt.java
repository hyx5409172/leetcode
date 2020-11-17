package topic;

public class RomanToInt {

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println(toInt(roman));
    }

    public static int toInt(String s){
        String[] roman = {"CM","M" ,"CD","D","XC","C","XL","L","IX","X","IV","V","I"};
        int[] num =      {900 ,1000,400 ,500,90  ,100,40  ,50 ,9   ,10 ,4   ,5  ,1};
        int ans = 0;
        for (int i = 0; i < roman.length; i++) {
            int index = s.indexOf(roman[i]);
            int n= 0;
            while(index > -1){
                n++;
                index = s.indexOf(roman[i], index + 1);
            }

            ans += n * num[i];
            s = s.replaceAll(roman[i], "");
        }

        return ans;
    }




}
