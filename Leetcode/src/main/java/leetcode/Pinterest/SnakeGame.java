package leetcode.Pinterest;

import java.util.*;

/**
 * Created by cc on 2017/7/2.
 */
public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    /**
     * Use a deque to keep positions of snakes.
     * first one is head.
     *
     * Use hash set to keep track of positions of snakes.
     */

    Deque<int[]> snake;
    Set<String> snakePos;
    int width, height, foodPos;
    int[][] food;
    public SnakeGame(int width, int height, int[][] food) {
         this.snake = new LinkedList<>();
         this.snakePos = new HashSet<>();
         snake.add(new int[]{0,0});
         snakePos.add(generateKey(0,0));
         this.width = width;
         this.height = height;
         this.foodPos = 0;
         this.food = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */


    /**
     * The strategy of move is
     * 1. Never need to remove head. Always change head to the new location as long as it does not hit anything.
     * 2. get current head.
     * 3. based on direction, get the new head position.
     * 4. if new head hit boarder, return -1.
     * 5. if new head position is food. move food position to next.
     * 6. otherwise, delete tail. (This is because if new position is food, tail is not delelte, because we add one more.)
     *                            if not food, then means any position moves to previous position, so delete tail.
     * 7. After deletion, before add new head to snake position, we check if new head hits snake body.
     *    if yes, return -1.
     *    if not, add new head to starting of deque, add head position to hashset, return size -1;
     * */
    public int move(String direction) {
        int[] head = snake.getFirst();
        int[] newHead = Arrays.copyOf(head, 2);
        if(direction.equals("U")) {
            newHead[0] -= 1;
        }
        else if(direction.equals("D")) {
            newHead[0] += 1;
        }
        else if(direction.equals("L")) {
            newHead[1] -= 1;
        }
        else if(direction.equals("R")) {
            newHead[1] += 1;
        }
        //hit boarder, return.
        if(newHead[0] < 0  || newHead[0] >= height || newHead[1] < 0 || newHead[1] >= width)
            return -1;

        //if new position is food, move food position to next
        if(foodPos < food.length && food[foodPos][0] == newHead[0] && food[foodPos][1] == newHead[1]){
            foodPos ++;
        }
        //if not food, remove last one.
        else {
            int[] last = snake.removeLast();
            snakePos.remove(generateKey(last[0],last[1]));
        }

        if(snakePos.contains(generateKey(newHead[0], newHead[1]))) {
            return -1;
        }
        snake.addFirst(newHead);
        snakePos.add(generateKey(newHead[0],newHead[1]));

        return snakePos.size() - 1;
    }

    private String generateKey(int x, int y){
        return x + "_" + y;
    }
}
