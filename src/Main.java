import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // read list of words from file
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/Testfiles/5757words.txt")));
        ArrayList<String> words = new ArrayList<String>();
        while (true) {
            String word = reader.readLine();
            if (word == null) {
                break;
            }
            assert word.length() == 5;  // inputcheck, if you run with assertions
            words.add(word);
        }

        // create a graph using the list of words
        Graph graph = new Graph(words);

        // create a BFS object
        BFS bfs = new BFS();

        // read test cases from file and search for path
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/Testfiles/5757testcase.txt")));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            assert line.length() == 11; // inputcheck, if you run with assertions
            String start = line.substring(0, 5);
            String goal = line.substring(6, 11);
            int path = bfs.search(graph, start, goal);
            System.out.println(path);
        }
    }
}