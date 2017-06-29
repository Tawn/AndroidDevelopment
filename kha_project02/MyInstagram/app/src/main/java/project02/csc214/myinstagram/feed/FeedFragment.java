package project02.csc214.myinstagram.feed;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    public static final String ARG_ID = "UserID";
    private List<User> mUserDatabase;

    public FeedFragment() {
        // Required empty public constructor
    }
    public static FeedFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_feed, container, false);
        Map<String, User> mUsers = UserDatabase.get(getContext()).getUserKey();
        User mCurrentUser = mUsers.get(MainActivity.USER_KEY);
        Log.i("feed", "onCreateView: " + mCurrentUser.getFirstname());
        // Camerea Setup
        if(mCurrentUser.getPhotoPath() != "abc") {
            String path = mCurrentUser.getPhotoPath();
            try {
                File file = new File(path, "profile.jpg");
                Log.i("photo", "path: " + file.toString());
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(file));
                ImageView img=(ImageView)view.findViewById(R.id.feed_image);
                img.setImageBitmap(b);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return view;
    }

}
