package enums;

public enum StatusCode {
    OK(200);

    int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
