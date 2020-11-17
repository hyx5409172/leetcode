package topic;

public class A1024_videoStitching {

    public static void main(String[] args) {
        A1024_videoStitching a1024_videoStitching = new A1024_videoStitching();
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int T = 10;

        System.out.println(a1024_videoStitching.videoStitching(clips, T));
    }


    public int videoStitching(int[][] clips, int T) {
        return greedyWay(clips, T);
    }

    public int greedyWay(int[][] clips, int T){
        int[] lengthIndex = new int[T];
        // 建立索引
        for (int i = 0,length = clips.length; i < length; i++){
            int start = clips[i][0];
            if(start >= T){
                continue;
            }
            int end = clips[i][1] > T? T:clips[i][1];
            int vLength = end - start;
            lengthIndex[start] = Math.max(vLength, lengthIndex[start]);
        }

        int start = 0;
        int cur = 0;
        int count = 0;
        while(cur < T){
            int maxLength = 0;
            for (int i = start; i <= cur ; i++) {
                maxLength = Math.max(maxLength, lengthIndex[i] - cur + i);
            }

            if(maxLength == 0){
                return -1;
            }

            start = cur + 1;
            cur += maxLength;
            count++;
        }

        return count;
    }

}
