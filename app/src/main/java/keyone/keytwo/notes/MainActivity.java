package keyone.keytwo.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.noteNameFrameLayout, NoteNameFragment.newInstance())
                .commit();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.noteDescriptionFrameLayout, NoteDescriptionFragment.newInstance(new Note("testName", "testText", 0)))
                    .commit();


        }
    }
}