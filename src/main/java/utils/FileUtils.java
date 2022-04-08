package utils;

import aquality.selenium.core.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static constants.ResourcesPath.CONFIG_PATH;
import static utils.TestingConfigurations.*;

public class FileUtils {

    public static File loadFile(String path) {
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Logger.getInstance().info("File was successfully read");
        } catch (FileNotFoundException ex) {
        }
        return file;
    }

    public static File getLogFile() {
        Logger.getInstance().info("Getting logs");
        return new File(getDataFromResources(CONFIG_PATH, "/logFIlePath"));
    }
}
