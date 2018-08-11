package vn.simthanglong.appgiaosim.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CanTran on 8/10/18.
 */
public class User {
    private int id;
    private String token;
    @SerializedName("username")
    private String userName;
    private String email;
    @SerializedName("phone_number")
    private String phone;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("department_id")
    private String departmentId;
    @SerializedName("department_code")
    private String departmentCode;
    @SerializedName("department_name")
    private String departmentName;
    private String role;
    @SerializedName("view_perms")
    private List<String> viewPerms;
    private String clone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getViewPerms() {
        return viewPerms;
    }

    public void setViewPerms(List<String> viewPerms) {
        this.viewPerms = viewPerms;
    }

    public String getClone() {
        return clone;
    }

    public void setClone(String clone) {
        this.clone = clone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", role='" + role + '\'' +
                ", viewPerms=" + viewPerms +
                ", clone='" + clone + '\'' +
                '}';
    }
}
