package e.satyamsharma.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import e.satyamsharma.myapplication.R;

public class FragmentTwo extends Fragment {
    String aName[] = {"Satyam", "Rahul", "Aman", "Javed", "Salim", "Shaksi", "Annu", "Mahi", "Javed", "Javed", "Javed", "Javed"};
    String aEmail[] = {"satyams2812@gmail.com", "rahul321@gmail.com", "amansinghal125@gmail.com", "javedqureshi321@gmail.com", "salimquresh12@gmail.com", "agrwalsakshi@gmail.com", "aanudubery@gmail.com", "mahisingh@hotmail.com", "javedqureshi321@gmail.com", "javedqureshi321@gmail.com", "javedqureshi321@gmail.com", "javedqureshi321@gmail.com"};
    int k[] = {R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account, R.drawable.account};
    Button b1;

    public FragmentTwo() {
        // Required empty public constructor


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ListView lst = (ListView) view.findViewById(R.id.lstview);
        custom adapter = new custom(getActivity(), aName, aEmail, k, b1);
        lst.setAdapter(adapter);
        return view;
    }


    public class custom extends ArrayAdapter<String> {
        String sName[], sEmail[];
        int kate[];
        Button btn;
        Context mContext;

        public custom(@NonNull Context context, String Name[], String Email[], int img[], Button b2) {
            super(context, R.layout.lstshowing, Name);
            sName = Name;
            sEmail = Email;
            kate = img;
            mContext = context;
            btn = b2;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;
            if (row == null) {
                LayoutInflater n = (LayoutInflater) mContext.getApplicationContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = n.inflate(R.layout.lstshowing, parent, false);
                holder = new ViewHolder(row);
                row.setTag(holder);

            } else {
                holder = (ViewHolder) row.getTag();
            }
            holder.tImage.setImageResource(k[position]);
            holder.tName.setText(aName[position]);
            holder.tEmail.setText(aEmail[position]);
            holder.tButton.setEnabled(true);
            holder.tButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Okay", Toast.LENGTH_SHORT).show();
                }
            });
            return row;
        }
    }

    public class ViewHolder {
        TextView tName, tEmail;
        ImageView tImage;
        Button tButton;

        public ViewHolder(View v) {
            tName = ((TextView) v.findViewById(R.id.name));
            tEmail = ((TextView) v.findViewById(R.id.email));
            tImage = ((ImageView) v.findViewById(R.id.imgshow));
            tButton = ((Button) v.findViewById(R.id.btnok));
        }
    }
}