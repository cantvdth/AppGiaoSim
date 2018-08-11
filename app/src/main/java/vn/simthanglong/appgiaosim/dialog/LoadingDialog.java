package vn.simthanglong.appgiaosim.dialog;

import android.app.Dialog;
import android.content.Context;

import vn.simthanglong.appgiaosim.R;


/**
 * Created by cantran.
 */
public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context, R.style.Theme_CustomProgressDialog);

        setContentView(R.layout.dialog_custom_progress);
        setCancelable(false);
    }
}