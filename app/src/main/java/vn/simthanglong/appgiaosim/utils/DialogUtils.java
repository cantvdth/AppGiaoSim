package vn.simthanglong.appgiaosim.utils;

import android.app.Activity;
import android.content.Context;

import vn.simthanglong.appgiaosim.R;
import vn.simthanglong.appgiaosim.dialog.AlertDialogOk;
import vn.simthanglong.appgiaosim.dialog.AlertDialogOkAndCancel;


/**
 * Created by cantran on 4/4/2017.
 */
public class DialogUtils {

    public static void showRetryDialog(Context context, AlertDialogOkAndCancel.AlertDialogListener alertDialogListener) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        new AlertDialogOkAndCancel(context, context.getString(R.string.retry_title), context.getString(R.string.retry_content), context.getString(R.string.app_name), context.getString(R.string.report_cancel), alertDialogListener);
    }

    public static void showOkAndCancelDialog(Context context, String title, String content, String submit, String cancel, AlertDialogOkAndCancel.AlertDialogListener alertDialogListener) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        new AlertDialogOkAndCancel(context, title, content, submit, cancel, alertDialogListener);
    }


    public static void showOkDialog(Context context, String title, String content, String submit, AlertDialogOk.AlertDialogListener alertDialogListener) {
        if (context == null) return;
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        new AlertDialogOk(context, title, content, submit, alertDialogListener);
    }




}
