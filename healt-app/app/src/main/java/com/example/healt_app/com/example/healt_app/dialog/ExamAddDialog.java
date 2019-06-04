package com.example.healt_app.com.example.healt_app.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.fragments.DatePickerFragment;

public class ExamAddDialog extends DialogFragment {

    private TextView tvDate;

    public void setDate(DialogFragment fragment, int year, int month, int day) {
        tvDate.setText(day + "/" + month + "/" + year);
    }

    public interface ExamAddDialogListener {
        public void onExamAddClick(DialogFragment dialog);
    }

    ExamAddDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExamAddDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_exam_add, null);

        tvDate = v.findViewById(R.id.tv_exam_date);

        Button btExamDate = v.findViewById(R.id.bt_exam_date);
        btExamDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(ExamAddDialog.this, 10);
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });

        builder.setView(v)
        .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onExamAddClick(ExamAddDialog.this);
            }
        });

        return builder.create();
    }
}
