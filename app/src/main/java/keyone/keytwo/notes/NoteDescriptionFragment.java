package keyone.keytwo.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NoteDescriptionFragment extends Fragment {
    public static String ARG_NOTE = "note";
    private Note note;

    public static NoteDescriptionFragment newInstance(Note note) {
        NoteDescriptionFragment fragment = new NoteDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_note_descrip, container, false);
        TextView textViewNoteName = view.findViewById(R.id.textViewNoteName);
        TextView textViewNoteDescription = view.findViewById(R.id.textViewNoteDescription);
        textViewNoteName.setText(this.note.getNoteName());
        textViewNoteDescription.setText(this.note.getNoteDescription());
        return view;
    }
}
