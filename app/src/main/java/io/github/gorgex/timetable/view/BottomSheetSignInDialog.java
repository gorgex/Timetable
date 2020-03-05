package io.github.gorgex.timetable.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.common.SignInButton;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import io.github.gorgex.timetable.R;

public class BottomSheetSignInDialog extends BottomSheetDialogFragment {

    private BottomSheetSignInListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_sign_in, container, false);

        SignInButton signInButton = v.findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSignInButtonClicked();
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (BottomSheetSignInListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetSignInListener");
        }
    }

    public interface BottomSheetSignInListener {
        void onSignInButtonClicked();
    }
}
