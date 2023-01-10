import java.util.*;

class BFS {
    public int search(Graph graph, String start, String goal) {
        Queue<String> queue = new LinkedList<>(); //Kö för noder att besöka.
        Set<String> visited = new HashSet<>(); //Set för redan besökta noder.
        queue.add(start); //Börja med att lägga till startnoden till kö:n.
        visited.add(start); //Sätt också in start noden som besökt.
        int count = 0; //Count är antalet noder, längden, från start nod till slut nod.
        while (!queue.isEmpty()) { //Vi fortsätter att iterera sålänge det finns noder för oss att besöka.
            int size = queue.size();
            for (int i = 0; i < size; i++) { //Itererar igenom kön.
                String current = queue.poll(); //Plockar ut det första ordet i kön.

                if (current.equals(goal)) { //Om ordet är detsamma som det vi söker har vi nått slutnoden och returnerar därmed count.
                    return count;
                }

                //Om vi inte hittat slutnoden, itererar vi igenom grannarna till noden vi är på.
                for (String neighbor : graph.getNeighbors(current)) {
                    if (!visited.contains(neighbor)) { //Om nodens granne inte redan är besökt så lägger vi till denna i kön och forsätter.
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            //När vi itererat igenom kön har vi kommit "en nod frammåt". Vi inkrementerar därför count med 1.
            count++;
        }
        // -1 returneras när det inte finns någon väg för oss att gå så att vi kan komma till slutnoden.
        return -1;
    }
}


