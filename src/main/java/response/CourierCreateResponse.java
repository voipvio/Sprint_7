package response;

public class CourierCreateResponse {

    private Boolean ok;
    private Integer code;
    private String message;

    public CourierCreateResponse(Boolean ok) {
        this.ok = ok;
    }

    public CourierCreateResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
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
