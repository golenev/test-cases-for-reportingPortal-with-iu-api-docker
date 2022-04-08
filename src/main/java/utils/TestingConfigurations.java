package utils;

public class TestingConfigurations {

    private TestingConfigurations() {
    }
    public static String getDataFromResources (String path, String key){
        return TestingEnvironment.getCurrentEnvironment(path).getValue(key).toString();
    }
}
