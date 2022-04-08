package constants;

import static utils.TestingConfigurations.*;

public class ResourcesPath {
    public final static String CONFIG_PATH = "configData.json";
    public final static String TESTING_PATH = "testingData.json";
    public final static String ENDPOINT_PATH = "endpoints.json";
    public final static String API_HOST = getDataFromResources(CONFIG_PATH, "/apiHost");
}
