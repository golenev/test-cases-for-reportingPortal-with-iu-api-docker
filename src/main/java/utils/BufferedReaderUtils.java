package utils;

import aquality.selenium.core.logging.Logger;

import java.io.*;

public class BufferedReaderUtils {
    public static String readUsingBufferedReader(File fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            Logger.getInstance().info("Can't read file from :" + fileName);
            e.printStackTrace();
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = null;
        while (true) {
            try {
                assert reader != null;
                if ((line = reader.readLine()) == null)
                    break;
            } catch (IOException e) {
                Logger.getInstance().info("Can't read file from :" + fileName);
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length());
        return stringBuilder.toString();
    }
}
