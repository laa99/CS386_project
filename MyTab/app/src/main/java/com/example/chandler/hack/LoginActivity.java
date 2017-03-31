package com.example.chandler.hack;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;
    Login Login = new Login();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        b1 = (Button)findViewById(R.id.login);
        b2 = (Button)findViewById(R.id.signUp);

        ed1 = (EditText)findViewById(R.id.emailText);
        ed2 = (EditText)findViewById(R.id.passText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Login.validateUser(ed1.getText().toString(), ed2.getText().toString())){
                    Toast.makeText(getBaseContext(),
                    "Redirecting...", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(),
                    "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),
                        "Attempting sign up...", Toast.LENGTH_SHORT).show();
                showSignUp();
            }
        });
    }

    public void showSignUp() {
        signUpDialog newFragment = signUpDialog.newInstance();
        newFragment.show(getFragmentManager(), "dialog");
    }

    public static class signUpDialog extends DialogFragment {

        EditText email, pass, passConfirm;
        Button b1, b2;

        static signUpDialog newInstance() {
            return new signUpDialog();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.sign_up, container, false);
            b1 = (Button)v.findViewById(R.id.Confirm);
            b2 = (Button)v.findViewById(R.id.Cancel);

            email = (EditText)v.findViewById(R.id.emailText);
            pass = (EditText)v.findViewById(R.id.passText);
            passConfirm = (EditText)v.findViewById(R.id.passTextConfirm);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pass.getText().toString().equals(passConfirm.getText().toString())) {
                        // Figure out some way to create user accounts to temporarily store in the
                        // system
                    }
                    else {
                        dismiss();
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return v;
        }
    }
}
