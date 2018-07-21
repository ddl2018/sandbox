package min.datastructurenalgorithm.codility;

public class RemoveDuplicates {
    public int[] solution(int[] A) {
        int length = A.length;
        if (length <= 1) {
            return A;
        }
        int[] indexes = new int[length];
        int currentElement;
        int comparedElment;
        int count = length;
        for (int i = 0; i < length - 1; i++) {
            if (indexes[i] != -1) {
                currentElement = A[i];
                for (int j = i + 1; j < length; j++) {
                    comparedElment = A[j];
                    if (comparedElment == currentElement) {
                        indexes[j] = -1;
                        count--;
                    }
                }
            }
        }
        int[] result = new int[count];
        for (int i = 0, j = 0; i < length; i++) {
            if (indexes[i]==0) {
                result[j] = A[i];
                j++;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        RemoveDuplicates test = new RemoveDuplicates();
        int[] A = {-5, -2, -5, 10};
        int[] B = test.solution(A);
        System.out.print("");
    }
}
