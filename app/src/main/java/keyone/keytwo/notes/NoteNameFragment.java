package keyone.keytwo.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NoteNameFragment extends Fragment {

    Note currentNote;

    public static NoteNameFragment newInstance() {
        return new NoteNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_note_name, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.noteNameArray);
        for(int i = 0; i < notes.length; i++) {
            String name = notes[i];
            TextView textViewName = new TextView(getContext());
            textViewName.setText(name);
            textViewName.setTextSize(30);
            linearLayout.addView(textViewName);
            int finalI = i;
            textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNote = new Note(getResources().getStringArray(R.array.noteNameArray)[finalI],
                            getResources().getStringArray(R.array.noteDescriptionArray)[finalI], 0);
                }
            });

        }

        return view;
    }
}
