import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
        printString("a letter");
    }

    private static void printString(String line) {
        ArrayList<String> stringList = new ArrayList<>();

        String previousString = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                previousString = line.substring(0, 1).toUpperCase() + line.substring(1, i);

                String newString = line.substring(i+1, i+2).toUpperCase() + line.substring(i+2);
                stringList.add(newString);
            }
        }

        for (String str: stringList) {
            previousString = previousString + " " + str;
        }

        System.out.println(previousString);
    }
}
