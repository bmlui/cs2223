import java.util.LinkedList;
import java.util.List;

public class Dijkstra {

    public static LinkedList<Integer>[] shortestDistancesList(int[][] graphOrig, int startingNode) {
        int graphSize = graphOrig[0][0];
        int[][] graph = new int[graphSize][graphSize];
        for (int i = 0; i < graphSize; i++) { //copying graph onto new graph, removing the first index as it is not needed
            for (int j = 0; j < graphSize; j++) {
                graph[i][j] = graphOrig[i + 1][j];
            }
        }

        LinkedList<Integer>[] distances = new LinkedList[graphSize];
        Boolean[] visited = new Boolean[graphSize];
        for (int i = 0; i < graphSize; i++) { //initializing distances array
            distances[i] = new LinkedList<Integer>();
            distances[i].addFirst(Integer.MAX_VALUE); // setting all distances to infinity/integer max value
            visited[i] = false; //setting all nodes to unvisited
        }
        distances[startingNode].set(0, 0); //setting the distance to the starting node to 0
        for (int i = 0; i < graphSize; i++) {
            int tempMin = Integer.MAX_VALUE;
            int tempMinIndex = -1;
            for (int j = 0; j < graphSize; j++) { //finding the node with the shortest distance
                if (visited[j] == false && distances[j].get(0) < tempMin) {
                    tempMin = distances[j].get(0);
                    tempMinIndex = j;
                }
            }
            visited[tempMinIndex] = true; //marking the node as visited
            for (int j = 0; j < graphSize; j++) { //updating the distances of the nodes adjacent to the node with the shortest distance
                if (!visited[j] && graph[tempMinIndex][j] != 0 && distances[tempMinIndex].get(0) != Integer.MAX_VALUE && distances[tempMinIndex].get(0) + graph[tempMinIndex][j] < distances[j].get(0)) {
                    distances[j] = new LinkedList<Integer>();
                    distances[j].addFirst( distances[tempMinIndex].get(0) + graph[tempMinIndex][j]);
                    distances[j].addAll(distances[tempMinIndex]);
                    distances[j].remove(1);
                    distances[j].addLast(tempMinIndex);
                }
            }
        }
        return distances;
    }

    public static LinkedList<Integer> shortestDistance(int[][] graphOrig, int startingNode, int endingNode) {
        LinkedList<Integer>[] list =  shortestDistancesList(graphOrig, startingNode);
        System.out.print("Shortest path from " + startingNode + " to " + endingNode + ": ");
        for (int i = 1; i< list[endingNode].size(); i++){
           System.out.print(list[endingNode].get(i) + " > ");
        }
        System.out.print(endingNode);
        System.out.println();
        System.out.println("Length of the shortest path: " + list[endingNode].get(0));

        return list[endingNode];
    }

}
