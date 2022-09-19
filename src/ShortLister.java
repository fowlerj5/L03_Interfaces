import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String args[]){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> shortStrings = new ArrayList<>();
        ShortWordFilter swf = new ShortWordFilter();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                String[] arrOfRec;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    arrOfRec = rec.split("[^\\w']");
                    for (String a : arrOfRec) {
                        strings.add(a);
                    }
                }
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for (Object x : strings) {
            if (swf.accept(x)) {
                System.out.print(x+" ");
            }
        }
    }
}
