package assignment08.csc214.mysqlite;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import assignment08.csc214.mysqlite.RecyclerView.CollectionRecyclerView;
import assignment08.csc214.mysqlite.poke_center.AddPokemonActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: invoked");
        manager = getSupportFragmentManager();
        CollectionRecyclerView fragment = new CollectionRecyclerView();
        manager.beginTransaction()
                .add(R.id.main_frame, fragment)
                .commit();

    }

    public void addPokemonButtonPress(View view) {
        Log.i(TAG, "addPokemonButtonPress: adding pokemon");
        Intent intent = new Intent(this, AddPokemonActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: creating new fragment");
        CollectionRecyclerView fragment = new CollectionRecyclerView();
        manager.beginTransaction()
                .add(R.id.main_frame, fragment)
                .commit();
    }
}
