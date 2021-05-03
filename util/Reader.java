package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
    public static BufferedReader getBufferedReaderInstance(String filePath)  {
        BufferedReader reader  = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }
    
}
