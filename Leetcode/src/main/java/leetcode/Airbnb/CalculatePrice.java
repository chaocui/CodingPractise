package leetcode.Airbnb;

import java.util.*;

/**
 * Created by cc on 2017/7/13.
 */

/**
 * input： float array[0.7, 4.8, 5.9, 2.4, 3.6]
 *        sum of input = 17.4 => round to 17.
 *
 * requirements:
 *       for each element in array:  either floor or ceil to integer,
 *       then make sure the ceiled/floored elements sum to 17 also.
 *       (minimize the sum of difference of each original number and ceiled/floored number)
 *       make sure sum of each difference between original and ceiled/floored number minimum
 * *
 * Good luck understand the question and coding them in 35 minutes.
 * Which is fucking impossible !!!!!!
 */
class CalculatePrice {

    public static class Pojo {
        float f;
        int i;

        public Pojo(float f, int i) {
            this.f = f;
            this.i = i;
        }
    }

    public List<Integer> round(List<Float> input) {

        float sumF = 0.0f;
        for (float f : input)
            sumF += f;
        int sum = Math.round(sumF);

        char[] actions = new char[input.size()];
        Arrays.fill(actions, 'f');

        int realSum = 0;
        List<Pojo> decimal = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            decimal.add(new Pojo(input.get(i) - (int) Math.floor(input.get(i)), i));
            realSum += (int) Math.floor(input.get(i));
        }

        Collections.sort(decimal, new Comparator<Pojo>() {
            public int compare(Pojo p1, Pojo p2) {
                if (p1.f - p2.f > 0.0f)
                    return 1;
                else if (p1.f - p2.f < 0.0f)
                    return -1;
                else
                    return 0;
            }
        });

        if (realSum < sum) {
            int count = 0;
            int index = decimal.size() - 1;
            while (count < sum - realSum) {
                actions[decimal.get(index).i] = 'c';
                count++;
                index--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (actions[i] == 'f')
                result.add((int) Math.floor(input.get(i)));
            else
                result.add((int) Math.ceil(input.get(i)));
        }
        return result;
    }


    public static void main(String[] args) {
        List<Float> input = Arrays.asList(.70f, 2.80f, 4.90f);
        CalculatePrice s = new CalculatePrice();
        List<Integer> result = s.round(input);
        for (int i : result)
            System.out.println(i);
    }
}

