package keyone.keytwo.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class NoteNameFragment extends Fragment {

    public static NoteNameFragment newInstance() {
        return new NoteNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_notes, container, false);
        return view;
    }
}
