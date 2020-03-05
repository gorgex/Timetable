package io.github.gorgex.timetable.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import io.github.gorgex.timetable.R;

public class BottomSheetSignOutDialog extends BottomSheetDialogFragment {

    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private BottomSheetSignOutListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_sign_out, container, false);

        ImageView userPhoto = v.findViewById(R.id.userPhoto);
        TextView userName = v.findViewById(R.id.userName);
        TextView userEmail = v.findViewById(R.id.userEmail);
        TextView signOutButton = v.findViewById(R.id.signOutButton);

        Picasso.get().load(user.getPhotoUrl()).fit().into(userPhoto);
        userName.setText(user.getDisplayName());
        userEmail.setText(user.getEmail());

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSignOutButtonClicked();
                dismiss();
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (BottomSheetSignOutListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetSignOutListener");
        }
    }

    public interface BottomSheetSignOutListener {
        void onSignOutButtonClicked();
    }
}
