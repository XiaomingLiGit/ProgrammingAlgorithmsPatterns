package ca.qc.vc.week6.lesson17;

import java.util.Arrays;

public class GACookies {
    public static int findContentChildren(int[] greed, int[] cookies) {

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int child = 0;
        int cookie = 0;

        while (child < greed.length && cookie < cookies.length) {

            if (cookies[cookie] >= greed[child]) {
                child++;
            }

            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {

    }
}
