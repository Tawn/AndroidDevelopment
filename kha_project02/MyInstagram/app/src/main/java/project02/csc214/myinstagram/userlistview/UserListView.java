package project02.csc214.myinstagram.userlistview;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;


public class UserListView extends Fragment {

    List<User> mUserList;
    public UserListView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list_view, container, false);
        ListView listView = (ListView)view.findViewById(R.id.user_list_view);
        mUserList = UserDatabase.get(getContext()).getUsers();
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mUserList
        );
        Log.d("UserListView", "onCreateView: " + mUserList.size());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), UserLookupActivity.class);
                String user =  mUserList.get(position).getUsername();
                intent.putExtra(MainActivity.USER_KEY, user);
                startActivity(intent);
            }
        });
        return view;
    }
}
