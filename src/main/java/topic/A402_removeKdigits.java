package topic;

public class A402_removeKdigits {

    public static void main(String[] args) {
        A402_removeKdigits a402 = new A402_removeKdigits();
        String num = "100200";
        int k = 1;
        System.out.println(a402.removeKdigits(num, k));
    }

    /**
     * 保证最大位最小，长度为7，删除3位，那么首位一定在前4位中取
     * */
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }

        StringBuilder sb = new StringBuilder(num);
        int start = 0;
        while (k > 0) {
            int minIndex = start;
            char minNum = '9';
            for (int i = 0; i < k + 1 && i + start < sb.length(); i++) {
                char cur = sb.charAt(start + i);
                if(cur < minNum){
                    minNum = cur;
                    minIndex = start + i;
                }

                if(cur == '0'){
                    break;
                }
            }

            if(minIndex > start){
                sb.delete(start, minIndex);
                k -= (minIndex - start);
            }

            start ++;

            if(num.length() - k < start){
                sb.delete(sb.length() - k, sb.length());
                break;
            }
        }

        if(sb.charAt(0) == '0'){
            int end = 0;
            while(end + 1 < sb.length() && sb.charAt(end + 1) == '0'){
                end ++;
            }

            sb.delete(0, end + 1);

            if(sb.length() == 0){
                sb.append("0");
            }
        }

        return sb.toString();
    }



}
