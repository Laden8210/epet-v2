package com.jasper.billingsystem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import com.google.android.material.textfield.TextInputLayout;
import com.jasper.billingsystem.MainActivity;
import com.jasper.billingsystem.R;
import com.jasper.billingsystem.api.PostCallback;
import com.jasper.billingsystem.api.PostTask;
import com.jasper.billingsystem.util.SessionManager;

import org.json.JSONObject;

public class SettingFragment extends Fragment {


    private Button btnLogout;
    private Button btnChangePassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        btnLogout = view.findViewById(R.id.btn_logout);
        btnChangePassword = view.findViewById(R.id.btn_change_password);

        btnLogout.setOnClickListener(this::logoutAction);

        btnChangePassword.setOnClickListener(this::changePasswordAction);
        return view;
    }

    private void changePasswordAction(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Change Password");

        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_change_password, null);

        TextInputLayout tfOldPassword = dialogView.findViewById(R.id.tf_old_password);
        TextInputLayout tfNewPassword = dialogView.findViewById(R.id.tf_new_password);
        TextInputLayout tfConfirmPassword = dialogView.findViewById(R.id.tf_confirm_password);

        builder.setView(dialogView);

        builder.setPositiveButton("Change", null); // Set the listener to null initially

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();

        dialog.setOnShowListener(dialogInterface -> {
            Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            button.setOnClickListener(v -> {
                boolean valid = true; // Flag to check if all validations pass

                // Reset errors
                tfOldPassword.setError(null);
                tfNewPassword.setError(null);
                tfConfirmPassword.setError(null);

                // Validate inputs
                if (tfOldPassword.getEditText().getText().toString().isEmpty()) {
                    tfOldPassword.setError("Old password is required");
                    valid = false;
                }

                if (tfNewPassword.getEditText().getText().toString().isEmpty()) {
                    tfNewPassword.setError("New password is required");
                    valid = false;
                }

                if (tfConfirmPassword.getEditText().getText().toString().isEmpty()) {
                    tfConfirmPassword.setError("Confirm password is required");
                    valid = false;
                }

                if (!tfNewPassword.getEditText().getText().toString().equals(tfConfirmPassword.getEditText().getText().toString())) {
                    tfConfirmPassword.setError("Password does not match");
                    valid = false;
                }

                if (valid) {
                    // Create JSON object for the password change request
                    try {

                        String userId = String.valueOf(SessionManager.getInstance(getContext()).getUserDetails().getSubscriberId());
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("subscriber_id", userId);
                        jsonObject.put("old_password", tfOldPassword.getEditText().getText().toString());
                        jsonObject.put("new_password", tfNewPassword.getEditText().getText().toString());
                        jsonObject.put("confirm_password", tfConfirmPassword.getEditText().getText().toString());

                        // Perform the password change request
                        new PostTask(getContext(), new PostCallback() {
                            @Override
                            public void onPostSuccess(String responseData) {
                                AlertDialog.Builder successBuilder = new AlertDialog.Builder(getContext());
                                successBuilder.setTitle("Success");
                                successBuilder.setMessage("Password changed successfully");
                                successBuilder.setPositiveButton("Ok", (dialog1, which1) -> {
                                    dialog1.dismiss();
                                    dialog.dismiss(); // Close the change password dialog
                                });
                                successBuilder.show();
                            }

                            @Override
                            public void onPostError(String errorMessage) {
                                AlertDialog.Builder errorBuilder = new AlertDialog.Builder(getContext());
                                errorBuilder.setTitle("Error");
                                errorBuilder.setMessage(errorMessage);
                                errorBuilder.setPositiveButton("Ok", (dialog1, which1) -> {
                                    dialog1.dismiss();
                                });
                                errorBuilder.show();
                            }
                        }, "Error", "changeSubscriberPassword").execute(jsonObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        dialog.show();
    }


    private void logoutAction(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            SessionManager.getInstance(getContext()).logoutUser();

            getContext().startActivity(new Intent(getContext(), MainActivity.class));
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();


    }
}