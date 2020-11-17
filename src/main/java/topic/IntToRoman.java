package topic;

public class IntToRoman {

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(toRoman(num));

        StringBuilder sb = new StringBuilder("abcdef");
        sb.replace(0, 5, "shit");
        System.out.println(sb);
    }


    public static String toRoman(int num) {
        int[] main = {1000, 100, 10, 1};
        String[] mainRoman = {"M", "C", "X", "I"};
        String[] subRoman = {"D", "L", "V"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < main.length; i++) {
            int n = num/main[i];
            num %= main[i];
            for (int j = 0; j < n; j++) {
                ans.append(mainRoman[i]);
            }

            if(i > 0){
                // 替换5
                String five = mainRoman[i] + mainRoman[i] + mainRoman[i] + mainRoman[i] + mainRoman[i];
                int fIndex = ans.indexOf(five);
                while(fIndex > -1){
                    ans.replace(fIndex, fIndex + 5, subRoman[i - 1]);
                    fIndex = ans.indexOf(five);
                }

                //替换4
                String four = mainRoman[i] + mainRoman[i] + mainRoman[i] + mainRoman[i];
                fIndex = ans.indexOf(four);
                while(fIndex > -1){
                    ans.replace(fIndex, fIndex + 4, mainRoman[i] + subRoman[i - 1]);
                    fIndex = ans.indexOf(four);
                }

                // 替换9
                String nine = subRoman[i - 1] + mainRoman[i] + subRoman[i - 1];
                fIndex = ans.indexOf(nine);
                while(fIndex > -1){
                    ans.replace(fIndex, fIndex + 3, mainRoman[i] + mainRoman[i-1]);
                    fIndex = ans.indexOf(nine);
                }
            }

        }

        return ans.toString();
    }

}
