package vn.simthanglong.appgiaosim.activity;

import android.content.Intent;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.simthanglong.appgiaosim.Constants;
import vn.simthanglong.appgiaosim.R;
import vn.simthanglong.appgiaosim.dialog.AlertDialogOkAndCancel;
import vn.simthanglong.appgiaosim.model.User;
import vn.simthanglong.appgiaosim.rest.ApiClient;
import vn.simthanglong.appgiaosim.rest.response.UserResponse;
import vn.simthanglong.appgiaosim.utils.DialogUtils;
import vn.simthanglong.appgiaosim.utils.LogUtils;
import vn.simthanglong.appgiaosim.utils.ProgressDialogUtils;
import vn.simthanglong.appgiaosim.utils.TransitionScreen;
import vn.simthanglong.appgiaosim.view.ButtonCustom;
import vn.simthanglong.appgiaosim.view.EdittextCustom;


/**
 * Created by CanTran on 5/23/17.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EdittextCustom edtUsername;
    private EdittextCustom edtPassword;
    private ButtonCustom btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        edtUsername = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);


    }

    @Override
    protected void initData() {


    }

    @Override
    protected void resumeData() {

    }

    private void doLogin() {
//        if (edtUsername.getText().toString().trim().isEmpty()) {
//            edtUsername.requestFocus();
//            return;
//        }
//        if (edtPassword.getText().toString().trim().isEmpty()) {
//            edtPassword.requestFocus();
//            return;
//        }
//        if (edtPassword.getText().toString().trim().length() < 5) {
//            edtPassword.requestFocus();
//            return;
//        }
//        ProgressDialogUtils.showProgressDialog(LoginActivity.this);
        JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest.put(Constants.PARAMETER_USERNAME, "Test_Giaovan");
            jsonRequest.put(Constants.PARAMETER_PASSWORD, "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtils.d(TAG, "doLogin jsonRequest : " + jsonRequest.toString());
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonRequest.toString());
        ApiClient.getApiService().login(body).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                ProgressDialogUtils.dismissProgressDialog();
                LogUtils.d(TAG, "doLogin code : " + response.code());
                LogUtils.d(TAG, "doLogin code : " + response.body().toString());
                if (response.code() == Constants.HTTP_CODE_OK) {
                    if (response!=null){
                        User user=response.body().getResponse();
//                        UserManager.insertUser();


                    }
//                    UserManager.insertUser(user);
//                    LogUtils.d(TAG, "doLogin code : " + UserManager.getUserEntity().getToken());

                    startActivity(new Intent(LoginActivity.this, LoginActivity.class), TransitionScreen.RIGHT_TO_LEFT);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                LogUtils.e(TAG, "doLogin onFailure : " + t.getMessage());
                ProgressDialogUtils.dismissProgressDialog();
                DialogUtils.showRetryDialog(LoginActivity.this, new AlertDialogOkAndCancel.AlertDialogListener() {
                    @Override
                    public void onSubmit() {
                        doLogin();
                    }

                    @Override
                    public void onCancel() {

                    }
                });
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                LogUtils.d(TAG,"onClick");
                doLogin();
                break;

        }
    }

}
