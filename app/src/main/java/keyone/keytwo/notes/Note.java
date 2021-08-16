package keyone.keytwo.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    public String noteName;
    public String noteDescription;
    public int noteIndex;

    public Note(String noteName, String noteDescription, int noteIndex) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.noteIndex = noteIndex;
    }

    protected Note(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        noteIndex = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(noteDescription);
        dest.writeInt(noteIndex);
    }
}
