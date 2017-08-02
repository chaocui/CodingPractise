package leetcode.medium;

/**
 * Created by cc on 2017/5/1.
 */
public class Prim {

    /**
     * Basic idea of Prim:
     * Take a vertex from vertex set.
     * Use an array track the distance from this vertex to other vertex.
     * Loop through the array, find the min distance from this vertex to other vertex.
     * Put that vertex into result set.
     *
     * Then update the array track
     * This part is tricky and important. understand this part is the key to understand the algorithm.
     * When update, only cares the vertex that are not in result. Which the value in the array should be -1.
     * means they are not reachable now. But check if they are reachable by current vertex.
     * 1. What is already in the array track is the min distance to each vertex from vertex which already in result.
     * Why?
     * Initially, its starts to all, we take the minimum one then put it into result.
     * then we find the one to other vertex's distance from the matrix. Then compare the existing distance to all vertex.
     * if existing vertexs are able to reach the vertex, it should be the minimum distance already, then compare to
     * the distance now, take the minimum one.
     * If the existing distance is maximum, then means it cannot be reached from existing vertex in result.
     * So we keep doing this, we can make sure the array always hold the minimum distance to vertex that are not in result.
     *
     *
     * Reference Link http://www.cnblogs.com/biyeymyhjob/archive/2012/07/30/2615542.html
     * */

    int[][] matrix; //input array
    int[] distance; //min distance from existing vertex to each vertex.
    int[] result;
    boolean[] visited;
    //take a starting point.
    public int prim(int start){
        int sumDist = 0;
        int index = 0;
        visited[start] = true;
        result[index++] = start;
        for(int i = 0; i < distance.length; i++)
            distance[i] = matrix[start][i];

        for(int i = 1; i < distance.length; i++){
            int minDist = Integer.MAX_VALUE;
            int eachVertex = 0;
            for(int j = 0; j < distance.length; j++){
                if(!visited[j] && distance[j] < minDist){
                    minDist = distance[j];
                    eachVertex = j;
                }
            }
            sumDist += minDist;
            result[index++] = eachVertex;
            visited[eachVertex] = true;
            for(int j = 0; j < distance.length; j++){
                if(!visited[j] && distance[j] > matrix[eachVertex][j]){
                    distance[j] = matrix[eachVertex][j];
                }
            }
        }
        return sumDist;
    }
}
