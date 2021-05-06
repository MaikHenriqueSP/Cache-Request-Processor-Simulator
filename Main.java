import java.io.BufferedReader;

import util.Reader;

public class Main {
    public static final String MAIN_INPUT_PATH ="./input/wikipedia.txt";
    public static final String BASE_INPUT_PATH ="./input/base_input.txt";

    public static void main(String[] args) {
        BufferedReader reader = Reader.getBufferedReaderInstance(MAIN_INPUT_PATH);
        Processor processor = new Processor();
        processor.process(reader);
        System.out.println("Total bytes requested: " + processor.getTotalBytesRequested());
        System.out.println("Total bytes in cache: " + processor.getTotalBytes().cached);
        System.out.println("Total bytes saved: " + processor.getTotalBytes().saved);
    }
}