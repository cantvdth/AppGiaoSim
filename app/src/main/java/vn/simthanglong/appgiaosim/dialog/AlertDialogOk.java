package vn.simthanglong.appgiaosim.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import vn.simthanglong.appgiaosim.R;
import vn.simthanglong.appgiaosim.view.TextViewCustom;

/**
 * Created by cantran on 5/8/2017.
 */

public class AlertDialogOk extends BaseDialog implements View.OnClickListener {

    private final String title;
    private final String content;
    private final String submit;

    public interface AlertDialogListener {
        void onSubmit();
    }

    private final AlertDialogListener alertDialogListener;

    public AlertDialogOk(@NonNull Context context, String title, String content, String submit, AlertDialogListener alertDialogListener) {
        super(context);
        this.title = title;
        this.content = content;
        this.submit = submit;
        this.alertDialogListener = alertDialogListener;

        showView();
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_alert_ok;
    }

    @Override
    protected void initData() {

        TextViewCustom tvSubmit = findViewById(R.id.tv_yes);
        tvSubmit.setOnClickListener(this);
        TextViewCustom tvTitle = findViewById(R.id.tv_title);
        TextViewCustom tvContent = findViewById(R.id.tv_content);

        tvTitle.setText(title);
        tvContent.setText(content);
        tvSubmit.setText(submit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_yes:
                if (alertDialogListener != null) alertDialogListener.onSubmit();
                hideView();
                break;
        }
    }
}
