package e.satyamsharma.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import e.satyamsharma.myapplication.R;

public class FragmentOne extends Fragment {
    public FragmentOne() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        Button b1 = (Button)view.findViewById(R.id.btnclickme);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(getActivity(),"Clicked on Tab1",Toast.LENGTH_SHORT).show();
            }
        });
       return  view;
        //return inflater.inflate(R.layout.fragment_one, container, false);

    }



}
