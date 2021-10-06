package com.example.interntask;

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


public class receiveFrag extends Fragment {



    public static receiveFrag newInstance(String param1, String param2) {
        receiveFrag fragment = new receiveFrag();
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

        View v = inflater.inflate(R.layout.fragment_receive, container, false);

        User user1 = new User("Ananya Rao","last interacted: 7d ago");
        User user2 = new User("Rajashi Prakash","last interacted: 3d ago");
        User user3 = new User("Harshada Nikam","last interacted: 4d ago");
        User user4 = new User("John Born","last interacted: 6d ago");


        ArrayList<User> arrayOfUsers = new ArrayList<User>();

        arrayOfUsers.add(user2);

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
