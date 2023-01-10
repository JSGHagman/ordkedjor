import java.sql.SQLOutput;
import java.util.*;

//Skapar en graf av en lista med ord.
class Graph {
    //Grafen innehåller en map. String är noden eller ordet. AdjecencyList är den nodens grannar.
    private Map<String, List<String>> adjacencyList;

    public Graph(List<String> words) {
        adjacencyList = new HashMap<>(); //Lista över grannar till en nod.
        for (String word : words) { // Itererar igenom words.
            adjacencyList.put(word, new ArrayList<>()); //Lägger till alla ord i adjencyList mappen och skapar en arraylist som value.
                                                        //Arraylisten är till för att innehålla grannarna.
        }

        for (int i = 0; i < words.size(); i++) { //Itererar igenom listan av ord.
            for (int j = 0; j < words.size(); j++) { //Nestlar en for loop som också itererar listan av ord.
                if (i == j) { //Om orden är samma index så jämför vi samma ord.
                    continue; //Vi använder continue för att hoppa över eftersom det är samma ord som jämförs.
                }
                if (isConnected(words.get(i), words.get(j))) { //Om de fyra sista bokstäverna i ord 1, finns i någon komibination i ord 2
                    addEdge(words.get(i), words.get(j)); //Så lägger vi till en kant emellan dem.
                }
            }
        }
    }

    //Denna metod lägger till ord2 som granne till nod word1.
    private void addEdge(String word1, String word2) {
        adjacencyList.get(word1).add(word2);
        //System.out.println(word1 + " -> " + word2);
    }

    //Returnerar listan med grannar som en nod har.
    public List<String> getNeighbors(String word) {
        return adjacencyList.get(word);
    }

    //Metod för att kontrollera om två ord har en väg emellan sig.
    //Om de fyra sista bokstäverna i ord 1, finns i någon komibination i ord 2 så returnerar metoden true.
    private boolean isConnected(String word1, String word2) {

        for (int i = 1; i < 5; i++) { //Itererar igenom de 4 sista bokstäverna.
            char c = word1.charAt(i); //I varje iteration tar vi ut en bokstav.
            int index = word2.indexOf(c); //Vi hämtar index av den bokstaven i ord två.
            if (index < 0) { //Om index är -1 så finns inte bokstaven i ord2 och vi returnerar false.
                return false;
            }
            //Vi tar sedan bort bokstaven vi just kontrollerade från ord 2. Detta för att undivka dubbel räkning.
            word2 = word2.substring(0, index) + word2.substring(index + 1);
        }
        //Om vi tar oss igenom hela iterationen av ord1 utan att returnera false, så har orden en väg mellan sig.
        return true;
    }
}



