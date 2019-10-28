package e.satyamsharma.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentThree extends Fragment {
    String sName, sPassword, sEmail, sMobile;
    String res;
    ProgressDialog dialog;
    EditText aName;
    EditText aPassword;
    EditText aEmail;
    EditText aMobile;
    Button aButton;

    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        aName = (EditText) view.findViewById(R.id.apiname);
        aPassword = (EditText) view.findViewById(R.id.apipassword);
        aEmail = (EditText) view.findViewById(R.id.apiemail);
        aMobile = (EditText) view.findViewById(R.id.apiphone);
        aButton = (Button) view.findViewById(R.id.sumbit);

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new sync().execute();
            }
        });


        return view;

    }


    public class sync extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPreExecute() {

            sName = aName.getText().toString();
            sPassword = aPassword.getText().toString();
            sEmail = aEmail.getText().toString();
            sMobile = aMobile.getText().toString();
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Wait");
            dialog.show();

        }

        @Override
        protected Void doInBackground(String... strings) {
            res = ASP_WebAPI.ApiRegister(sName, sPassword, sEmail, sMobile, "Register");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (dialog.isShowing()) {
                dialog.dismiss();

                if (res == "Error occured") {
                    Toast.makeText(getActivity(), "Something went Wrong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}