import java.sql.SQLOutput;
import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph(List<String> words) {
        adjacencyList = new HashMap<>();
        for (String word : words) {
            adjacencyList.put(word, new ArrayList<>());
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i == j) {
                    continue;
                } if (isConnected(words.get(i), words.get(j))) {
                    addEdge(words.get(i), words.get(j));

                }
            }
        }
    }

    private void addEdge(String word1, String word2) {
        adjacencyList.get(word1).add(word2);
        //System.out.println(word1 + " -> " + word2);
    }

    public List<String> getNeighbors(String word) {
        return adjacencyList.get(word);
    }

    private boolean isConnected(String word1, String word2) {
        for (int i = 1; i < 5; i++) {
            char c = word1.charAt(i);
            int index = word2.indexOf(c);
            if (index < 0) {
                return false;
            }
        }
        return true;
    }

}



