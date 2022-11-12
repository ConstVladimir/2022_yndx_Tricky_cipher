import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static final String inputFile = "input.txt";
    private static final String outputFile = "output.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder itog = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i<n; i++){
            String[] men = reader.readLine().split(",");
            String fio = men[0]+men[1]+men[2];
            Set<Character> charsSet = fio.chars()
                    .mapToObj(e->(char)e).collect(Collectors.toSet());
            //System.out.println(charsSet.size());
            int a = Arrays.stream((men[3] + men[4]).split("")).mapToInt(l->Integer.parseInt(l)).reduce((x,y)->x+y).orElse(0);
            int f = men[0].toLowerCase().charAt(0)-'a'+1;
            //System.out.println(a + " " + f);
            int reslt = charsSet.size()+64*a+256*f;
            //System.out.println (reslt);
            String hexReslt = Integer.toHexString(reslt).toUpperCase();
            String d = hexReslt.substring(hexReslt.length() - 3);
            itog.append(d).append(" ");
        }

        FileWriter file = new FileWriter(outputFile);
        file.write(itog.substring(0));
        file.close();
    }
}
