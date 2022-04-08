package enums;

public enum QueryParamsKeys {
    TEST_ID("testId"),
    CONTENT("content"),
    CONTENT_TYPE("contentType"),
    PROJECT_ID("projectId"),
    SID("SID"),
    PROJECT_NAME("projectName"),
    TEST_NAME("testName"),
    METHOD_NAME("methodName"),
    ENV("env");

    String paramKey;

    QueryParamsKeys(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamKey() {
        return paramKey;
    }
}
