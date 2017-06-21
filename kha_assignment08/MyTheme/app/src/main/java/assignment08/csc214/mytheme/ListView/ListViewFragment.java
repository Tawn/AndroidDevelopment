package assignment08.csc214.mytheme.ListView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import assignment08.csc214.mytheme.Collection.Person;
import assignment08.csc214.mytheme.Collection.PersonCollection;
import assignment08.csc214.mytheme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    private List<Person> mList;
    private ListView mListView;
    private TextView tvListViewText;

    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        // Get arguments



        mList = PersonCollection.get(getActivity()).getList();
        mListView = (ListView)view.findViewById(R.id.lv_main);

        // Changing fragment text
        tvListViewText = (TextView)view.findViewById(R.id.tv_list_view);
        tvListViewText.setText("hello");
        // Setting adapter then return view
        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mList
        );
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
