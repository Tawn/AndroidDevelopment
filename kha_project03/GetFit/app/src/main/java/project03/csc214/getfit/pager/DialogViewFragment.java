package project03.csc214.getfit.pager;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import project03.csc214.getfit.HomeActivity;
import project03.csc214.getfit.R;
import project03.csc214.getfit.model.Day;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogViewFragment extends DialogFragment {

    public static int result_code = 1;
    public DialogViewFragment() {
        // Required empty public constructor
    }

    public DialogViewFragment newInstance(Day day) {
        DialogViewFragment dialog = new DialogViewFragment();
        Bundle args = new Bundle();
        args.putString("Day", day.getDay());
        args.putString("Routine", day.getRoutine());
        args.putString("Note", day.getNote());
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog_view, null);

        Bundle args = getArguments();
        String day = args.getString("Day");
        String routine = args.getString("Routine");
        String note = args.getString("Note");
        TextView tvDay = (TextView)view.findViewById(R.id.dialog_day);
        TextView tvRoutine = (TextView)view.findViewById(R.id.dialog_routine);
        TextView tvNote = (TextView)view.findViewById(R.id.dialog_note);

        tvDay.setText(day);
        tvRoutine.setText(routine);
        tvNote.setText(note);
        return new AlertDialog.Builder(getContext())
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Not done yet?", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getTargetFragment().getActivity(), HomeActivity.class);
                        startActivity(intent);
                    }
                })
                .setTitle("Note saved for next week")
                .setView(view)
                .create();
    }

    public void sendResult(int result) {
        getTargetFragment().onActivityResult(getTargetRequestCode(), result, null);
    }
}
