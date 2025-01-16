package response;

public class CourierLoginResponse {
    private Integer id;
    private Integer code;
    private String message;

    public CourierLoginResponse(Integer id) {
        this.id = id;
    }

    public CourierLoginResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
