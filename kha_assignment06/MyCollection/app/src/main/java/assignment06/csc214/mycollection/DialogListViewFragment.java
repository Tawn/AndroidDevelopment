package assignment06.csc214.mycollection;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import assignment06.csc214.mycollection.model.Pokemon;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogListViewFragment extends DialogFragment {

    public static final String ARG_NAME = "ITEM NAME";
    public static final String ARG_TYPE = "ITEM TYPE";
    public static final String ARG_HP = "ITEM HITPOINTS";
    public static final String ARG_DESC = "ITEM DESCRIPTION";

    public DialogListViewFragment() {
        // Required empty public constructor
    }

    public DialogListViewFragment newInstance(Pokemon pokemon) {
        DialogListViewFragment dialog = new DialogListViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, pokemon.getName());
        args.putString(ARG_TYPE, pokemon.getmType());
        args.putString(ARG_HP, pokemon.getmHitPoints() + " HP");
        args.putString(ARG_DESC, pokemon.getDescription());
        dialog.setArguments(args);
        return dialog;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog_list_view, null);
        Bundle args = getArguments();
        String name = args.getString(ARG_NAME);
        String type = args.getString(ARG_TYPE);
        String hp = args.getString(ARG_HP);
        String desc = args.getString(ARG_DESC);
        TextView tvName = (TextView)view.findViewById(R.id.item_name);
        TextView tvType = (TextView)view.findViewById(R.id.item_type);
        TextView tvHP = (TextView)view.findViewById(R.id.item_hp);
        TextView tvDesc = (TextView)view.findViewById(R.id.item_desc);

        tvName.setText(name);
        tvType.setText(type);
        tvHP.setText(hp);
        tvDesc.setText(desc);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.des)
                .setPositiveButton("done",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode) {
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, null);
    }
}
