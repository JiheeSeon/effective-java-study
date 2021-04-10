package main.java.ch2.item5;

import java.io.*;
import java.util.*;

class InputGetterWithDI {
    private final int[] input;

    public InputGetterWithDI(String input) {
        this.input = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] getInput() {
        return input;
    }
}

public class MNDI {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input = new InputGetterWithDI(reader.readLine()).getInput();
        System.out.println(new Solution(input).getAnswer());
    }

    private static class Solution {
        private final int N;
        private final int M;
        private final int[] nums;
        private final StringBuilder builder = new StringBuilder();

        Solution(int[] input) {
            this.N = input[0];
            this.M = input[1];
            this.nums = new int[M];
        }

        public String getAnswer() {
            backTrack(1,0);
            return builder.toString();
        }

        private void backTrack(int present, int depth) {
            if(depth == M) {
                for(int i : nums) {
                    builder.append(i).append(" ");
                }
                builder.append("\n");
                return;
            }

            for(int i = present; i <= N; i++) {
                nums[depth] = i;
                backTrack(i,depth + 1);
                nums[depth] = 0;
            }
        }
    }
}