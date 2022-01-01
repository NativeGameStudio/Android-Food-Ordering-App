package com.example.ratingapp.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.example.ratingapp.R;

/** Now the user will use this dialog to comment.
 *  Using a DialogFragment to contain dialog,
 *  so you can control dialog's lifecycle
 */
public class RatingDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Create dialog
        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.fragment_rating_dialog);

        // OK button
        Button btnOK = dialog.findViewById(R.id.btn_OK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cancel dialog
                dialog.cancel();
            }
        });

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        return dialog;
    }

}