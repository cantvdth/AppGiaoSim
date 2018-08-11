package vn.simthanglong.appgiaosim.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import vn.simthanglong.appgiaosim.utils.TypefaceContainer;


/**
 * Created by CanTran on 5/16/17.
 */

public class RadioButtonCustom extends AppCompatRadioButton {
    public RadioButtonCustom(Context context) {
        super(context);
        init();
    }

    public RadioButtonCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioButtonCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        if (!isInEditMode()) {
            Typeface tf;
            try {
                int styleTxt = getTypeface().getStyle();

                switch (styleTxt) {
                    case Typeface.NORMAL:
                        tf = TypefaceContainer.TYPEFACE_LIGHT;
                        break;
                    case Typeface.BOLD:
                        tf = TypefaceContainer.TYPEFACE_REGULAR;
                        break;
                    case Typeface.ITALIC:
                        tf = TypefaceContainer.TYPEFACE_LIGHT;
                        break;
                    case Typeface.BOLD_ITALIC:
                        tf = TypefaceContainer.TYPEFACE_LIGHT;
                        break;
                    default:
                        tf = TypefaceContainer.TYPEFACE_LIGHT;
                        break;
                }
            } catch (Exception e) {
                tf = TypefaceContainer.TYPEFACE_LIGHT;
            }
            setTypeface(tf);
        }
    }

}
