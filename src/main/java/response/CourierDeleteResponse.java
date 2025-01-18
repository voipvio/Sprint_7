package response;

public class CourierDeleteResponse {

    private Boolean ok;
    private String message;

    public CourierDeleteResponse(Boolean ok) {
        this.ok = ok;
    }

    public CourierDeleteResponse(String message) {
        this.message = message;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
