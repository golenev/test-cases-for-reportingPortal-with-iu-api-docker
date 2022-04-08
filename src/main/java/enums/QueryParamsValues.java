package enums;

public enum QueryParamsValues {
    IMAGE("image/png"),
    TEXT("text/html");

    String paramValue;

    QueryParamsValues(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}
