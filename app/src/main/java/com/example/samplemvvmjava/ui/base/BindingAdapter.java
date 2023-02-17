package com.example.samplemvvmjava.ui.base;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class BindingAdapter {



    @androidx.databinding.BindingAdapter("onEditorAction")
    public static void onEditorAction(EditText editText, View.OnClickListener action){



        editText.setOnEditorActionListener(
                (view, editorAction, id)->{


                    if(editorAction == EditorInfo.IME_ACTION_SEARCH){
                        InputMethodManager im = view.getContext().getSystemService(InputMethodManager.class);
                        im.hideSoftInputFromWindow(view.getWindowToken(),0);
                        action.onClick(editText);
                        view.clearFocus();
                        return true;
                    }

                    return false;
                }
        );

    }
}
