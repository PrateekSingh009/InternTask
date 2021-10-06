package com.example.interntask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.google.android.material.internal.ContextUtils.getActivity;
import static java.util.Objects.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link returnFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class returnFrag extends Fragment {


    public static returnFrag newInstance(String param1, String param2) {
        returnFrag fragment = new returnFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_return, container, false);

        User user1 = new User("Ananya Rao","last interacted: 7d ago");
        User user2 = new User("Rajashi Prakash","last interacted: 3d ago");
        User user3 = new User("Harshada Nikam","last interacted: 4d ago");
        User user4 = new User("John Born","last interacted: 6d ago");


        ArrayList<User> arrayOfUsers = new ArrayList<User>();
        arrayOfUsers.add(user1);
        arrayOfUsers.add(user2);
        arrayOfUsers.add(user3);
        arrayOfUsers.add(user4);


        UsersAdapter adapter = new UsersAdapter(getActivity(), arrayOfUsers);

        ListView listView = (ListView)v.findViewById(R.id.listView);
        listView.setAdapter(adapter);


        LinearLayout ll = (LinearLayout)v.findViewById(R.id.friendDrop);
        ImageView friendup = (ImageView)v.findViewById(R.id.friendUp);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ll.setVisibility(View.INVISIBLE);
               friendup.setVisibility(View.VISIBLE);
               listView.setVisibility(View.VISIBLE);
            }
        });

        friendup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setVisibility(View.VISIBLE);
                friendup.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.INVISIBLE);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), NameActivity.class);
                String message = arrayOfUsers.get(position).name;
                intent.putExtra("0", message);
                startActivity(intent);
            }
        });


        return v;
    }


}

class UsersAdapter extends ArrayAdapter<User> {


    public UsersAdapter(@NonNull FragmentActivity context, ArrayList<User> arrayList ) {
        super(context , 0,arrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listviewitem, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.friendname);
        TextView tvHome = (TextView) convertView.findViewById(R.id.frienddue);
        // Populate the data into the template view using the data object
        tvName.setText(user.name);
        tvHome.setText(user.dueDate);
        // Return the completed view to render on screen
        return convertView;
    }
}