package keyone.keytwo.notes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NoteNameFragment extends Fragment {

    Note currentNote;
    boolean isLandScape;
    public static String KEY_NOTE = "note";

    public static NoteNameFragment newInstance() {
        return new NoteNameFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if(savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(KEY_NOTE);
        }
        if(isLandScape) {
            if(currentNote != null) {
                showNoteDescription(1); // как здесь получить инт из currentNote?
//                showNoteDescription(currentNote.getNoteDescription());
//                showNoteDescriptionLand();
            }
            showNoteDescription(0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_note_name, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.noteNameArray);
        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];
            TextView textViewName = new TextView(getContext());
            textViewName.setText(name);
            textViewName.setTextSize(30);
            linearLayout.addView(textViewName);
            int finalI = i;
            textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showNoteDescription(finalI);
                }
            });
        }
        return view;
    }

    private void showNoteDescription(int index) {
        currentNote = new Note(getResources().getStringArray(R.array.noteNameArray)[index],
                getResources().getStringArray(R.array.noteDescriptionArray)[index], 0);
        if (isLandScape) {
            showNoteDescriptionLand();
        } else {
            showNoteDescriptionPort();
        }
    }

    private void showNoteDescriptionPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.noteNameFrameLayout, NoteDescriptionFragment.newInstance(currentNote))
                .addToBackStack("")
                .commit();
    }

    private void showNoteDescriptionLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.noteDescriptionFrameLayout, NoteDescriptionFragment.newInstance(currentNote))
                .commit();
    }
}
