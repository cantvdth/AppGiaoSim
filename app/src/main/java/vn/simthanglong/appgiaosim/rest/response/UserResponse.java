package vn.simthanglong.appgiaosim.rest.response;

import vn.simthanglong.appgiaosim.model.User;

/**
 * Created by CanTran on 8/10/18.
 */
public class UserResponse {
    private String status;
    private String message;
    private User response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getResponse() {
        return response;
    }

    public void setResponse(User response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "loginResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}

