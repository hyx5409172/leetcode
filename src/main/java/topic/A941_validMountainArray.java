package topic;

public class A941_validMountainArray {

    public static void main(String[] args) {
        A941_validMountainArray a941_validMountainArray = new A941_validMountainArray();
        int[] A = {0,1,2,3,4,5,6,7,8,9};

        System.out.println(a941_validMountainArray.validMountainArray(A));
    }

    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }

        int left = 0,right = A.length - 1;

        while(left < A.length - 1 && right > 1){
            if(A[left] < A[left + 1] ){
                left ++;
                continue;
            }

            if(A[right- 1] > A[right]){
                right --;
                continue;
            }

            break;
        }

        return right == left && left != 0 && right != A.length - 1;
    }

}
