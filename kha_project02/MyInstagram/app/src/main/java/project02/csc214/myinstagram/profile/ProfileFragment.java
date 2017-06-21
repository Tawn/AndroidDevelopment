package project02.csc214.myinstagram.profile;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;
import project02.csc214.myinstagram.userlistview.UserLookupActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    List<User> mUserList;
    private List<User> mUsers;
    private Map<String, User> mUserKey;
    private User mCurrentUser;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        mUsers = UserDatabase.get(getContext()).getUsers();
        mUserKey = UserDatabase.get(getContext()).getUserKey();
        mCurrentUser = mUserKey.get(MainActivity.CURRENT_USER);
        String user = mCurrentUser.getUsername();
        String first = mCurrentUser.getFirstname();
        String last = mCurrentUser.getLastname();
        TextView text = (TextView)view.findViewById(R.id.profile_username);
        TextView text2 = (TextView)view.findViewById(R.id.profile_tv_full_name);
        text.setText(user);
        text2.setText(first + " " + last);




        ListView listView = (ListView)view.findViewById(R.id.profile_list_view);
        mUserList = UserDatabase.get(getContext()).getUsers();
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mUserList
        );


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

        return  view;
    }

}
