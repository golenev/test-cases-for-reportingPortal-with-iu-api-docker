package utils;

import aquality.selenium.core.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static constants.ResourcesPath.CONFIG_PATH;
import static utils.TestingConfigurations.*;

public class EncodeUtils {

    public static String encodeFileToBase64Binary(File file) {
        String encodingFile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodingFile = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), getDataFromResources(CONFIG_PATH, "/encodingType"));
        } catch (FileNotFoundException e) {
            Logger.getInstance().info("FileNotFoundException!");
            e.printStackTrace();
        } catch (IOException e) {
            Logger.getInstance().info("IOException!");
            e.printStackTrace();
        }
        return encodingFile;
    }
}
