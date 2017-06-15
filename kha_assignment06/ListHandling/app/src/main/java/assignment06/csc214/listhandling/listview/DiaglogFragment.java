package assignment06.csc214.listhandling.listview;


import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


import assignment06.csc214.listhandling.R;
import assignment06.csc214.listhandling.model.Pokemon;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiaglogFragment extends DialogFragment {

    public static final String ARG_DESCRIPTION = "POKEMON_DESC";

    public DiaglogFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diaglog, container, false);
    }

}
