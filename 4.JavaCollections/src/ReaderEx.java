import java.io.*;

public class ReaderEx {
    public static void main(String[] args) throws Exception {
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";

        //это строчка – ключевая: мы «превратили» строку в Reader
        StringReader reader = new StringReader(test);

        executor(reader);
    }

    public static void executor(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String line = "";

        File file = new File("k://JavaRush/b.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            while ((line = br.readLine()) != null) {
                writer.write(line);
                System.out.println(line);
            }
        }
    }
}

