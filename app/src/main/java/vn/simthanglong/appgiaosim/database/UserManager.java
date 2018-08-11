package vn.simthanglong.appgiaosim.database;

import io.realm.Realm;
import vn.simthanglong.appgiaosim.utils.LogUtils;

/**
 * Created by cantran.
 */
public class UserManager {

    private static final String TAG = UserManager.class.getName();

    public static boolean checkLogin() {
        Realm realm = Realm.getDefaultInstance();
        UserEntity userEntity = realm.where(UserEntity.class).findFirst();
        return userEntity != null && userEntity.getUserName() != null;
    }

    public static UserEntity getUserEntity() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UserEntity.class).findFirst();
    }

    public static String getUserToken() {
        String result = "";
        LogUtils.d(TAG, "getUserToken start ");
        Realm realm = Realm.getDefaultInstance();
        // get last update
        UserEntity userEntity;
        if (realm.where(UserEntity.class) != null) {
            userEntity = realm.where(UserEntity.class).findFirst();
            if (userEntity != null) {
                result = userEntity.getToken();
            }
        }
      LogUtils.d(TAG, "getUserToken result : " + result);
        return result;
    }

    public static void insertUser(UserEntity userEntity) {
    LogUtils.d(TAG, "insertUser : " + userEntity.toString());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(userEntity);
        realm.commitTransaction();
    }

//    private static UserEntity convertUserEntity(User user) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(user.getId());
//        userEntity.setToken(user.getToken());
//        userEntity.setUserName(user.getUserName());
//        userEntity.setEmail(user.getEmail());
//        userEntity.setPhone(user.getPhone());
//        userEntity.setFullName(user.getFullName());
//        userEntity.setDepartmentId(user.getDepartmentId());
//        userEntity.setDepartmentName(user.getDepartmentName());
//        userEntity.setDepartmentCode(user.getDepartmentCode());
//
//        return userEntity;
//
//        private int id;
//        private String token;
//        @SerializedName("username")
//        private String userName;
//        private String email;
//        @SerializedName("phone_number")
//        private String phone;
//        @SerializedName("full_name")
//        private String fullName;
//        @SerializedName("department_id")
//        private String departmentId;
//        @SerializedName("department_code")
//        private String departmentCode;
//        @SerializedName("department_name")
//        private String departmentName;
//        private String role;
//        @SerializedName("view_perms")
//        private List<String> viewPerms;
//        private String clone;
//    }

}