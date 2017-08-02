package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/11.
 */
public class ValidTriangleNumber {

    /**
     * Basic idea is
     * sort the give array.
     * set the longest edge as the right most.
     * outer loop will decrese the longest edge.
     *
     * inner loop, from left = 0, right = longest - 1.
     * if sum > longest, then from left to right(right fix) all can form.
     * then move right--, (if bigger, we decrease one of them.)
     * else move left ++.(if smaller, we need to increase one of them.)
     * */



}
