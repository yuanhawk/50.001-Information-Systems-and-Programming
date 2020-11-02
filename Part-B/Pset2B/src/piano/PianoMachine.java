package piano;

import midi.Midi;
import music.NoteEvent;
import music.Pitch;
import midi.Instrument;

//import javax.sound.midi.Instrument;
import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;

public class PianoMachine{

	private Midi midi;
	//create a field for the instrument mode
    private Instrument instrument = Instrument.PIANO;
    //tracks the changes in semitone
    private int change_semi=0;
    //create a boolean variable to track the recording status
    private boolean is_recording = false;
    private boolean is_playback = false;

    //public Pitch nextPitch;
    //create the array list to check whether the key is
    //use primitive to not worry about the objects and non objects
    //ArrayList<Integer> now_playing = new ArrayList<>();
    //create a new array
    ArrayList<NoteEvent> replay = new ArrayList<>();
    //create a new variable for the playback
    //PianoMachine play_back;
    //create a new variable to instantiate the timings etc.
    //NoteEvent track;
    Pitch new_pitch;
	/**
	 * constructor for PianoMachine.
	 *
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        //TODO implement for qn 1
        //create an array list, don't forget that you can play multiple keys at once
        //if the input is not already in add it to the array list
        /*if(now_playing.contains(rawPitch.toMidiFrequency())==false){
            now_playing.add(rawPitch.toMidiFrequency());
            //play the note
            midi.beginNote(rawPitch.toMidiFrequency(),instrument);
            //for qn 2 pass the instrument inside the midi function
        }*/
        //track the playback in the arraylist
        //introduce the local variable to prevent the memory leaks
        if (is_playback==false){
            new_pitch=rawPitch.transpose(change_semi);
        }
        else{
            new_pitch= rawPitch;
        }

        if (is_recording){
            //track the long of the time
            long time = (long) System.currentTimeMillis();
            //System.out.println(time);
            replay.add(new NoteEvent(new_pitch,time,instrument, NoteEvent.Kind.start));
        }
        //System.out.println("test");
        //keep an integer to track the octave
        midi.beginNote(new_pitch.toMidiFrequency(),instrument);
        /*if(now_playing.contains(new_pitch.toMidiFrequency())==false){
        now_playing.add((Integer)new_pitch.toMidiFrequency());

        }*/

    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
    	//midi.endNote(new Pitch(0).toMidiFrequency());
    	//TODO implement for question 1
        /*if(now_playing.contains(rawPitch.toMidiFrequency())==true){
            now_playing.remove((Integer)rawPitch.toMidiFrequency());
            midi.endNote(rawPitch.toMidiFrequency(),instrument);
        }*/
        if (is_playback==false){
            new_pitch=rawPitch.transpose(change_semi);
        }
        else{
            new_pitch= rawPitch;
        }
        //new_pitch=rawPitch.transpose(change_semi);
        if (is_recording){
            long time =(long) System.currentTimeMillis();
            //System.out.println(time);
            replay.add(new NoteEvent(new_pitch,time,instrument,NoteEvent.Kind.stop));
        }
        midi.endNote(new_pitch.toMidiFrequency(),instrument);

        /*if(now_playing.contains(new_pitch.toMidiFrequency())==true){
            now_playing.remove((Integer)new_pitch.toMidiFrequency());
            midi.endNote(new_pitch.toMidiFrequency(),instrument);
        }
        //modify the endnote to track the change in the pitch*/
    }

    //TODO write method spec
    public void changeInstrument() {
       	//TODO: implement for question 2
        //check if the key is on. Use the array to check if the key is on. Add to the array true if the key is on
        //don't need to check if on one by one. have 256 keys
        //I key basically switches the instrument
        instrument= instrument.next();
        //pass instrument to begin and end note
    }

    //TODO write method spec
    public void shiftUp() {
    	//TODO: implement for question 3
        //press c to shift by 12 semitones
        //make use of the pitch.java to do the difference in the semitones

        if (Pitch.OCTAVE * 2 > change_semi){
            //music.Pitch.transpose(change_semi+Pitch.OCTAVE);
            change_semi += Pitch.OCTAVE;
        }

    }

    //TODO write method spec
    public void shiftDown() {
    	//TODO: implement for question 3
        //press v to shift by 12 semitones
        if((Pitch.OCTAVE*2*-1)< change_semi){
            change_semi -= Pitch.OCTAVE;

        }}


    //TODO write method spec
    public boolean toggleRecording() {
        //TODO: implement for question 4
        // R must toggle the recording on and off
        //if recording is off
        //press r to make a new recording and destroy the old one
        //to destroy the old one, should return false
        // based on the above, we have to create something that tracks the recording states
        if (is_recording) {
            //set the recording to turn off on key press again
            is_recording= false;

        }
        else{
            is_recording =true;
            // clear the replay
            replay = new ArrayList<>();
        }
        return is_recording;
    }

    //TODO write method spec
    public void playback() {
        //TODO: implement for question 4
        //playback the whole thing
        //play back the whole array list exactly
        //record the timing
        //record the pitch and instrument played at the same time
        // detect the kind as stop, determine the kind when creating a new note event, kind.start is for the note itself
        is_playback = true;
        for (int i = 0; i <= replay.size() - 1; i++) {
            //kind is just for checking
            NoteEvent noteEvent = replay.get(i);
            NoteEvent.Kind noteEventKind = noteEvent.getKind();
            //begin the note and end note
            if(noteEventKind == NoteEvent.Kind.start){
                //transpose only if it's not playback
                midi.beginNote(noteEvent.getPitch().toMidiFrequency(), noteEvent.getInstr());

            }
            else{
                midi.endNote(noteEvent.getPitch().toMidiFrequency(),noteEvent.getInstr());
            }
            if (i< replay.size()-1){
                NoteEvent nextNoteEvent = replay.get(i+1);
                int delay = (int)(Math.round((nextNoteEvent.getTime()-noteEvent.getTime())/10.0));
                Midi.rest(delay);

            }

    }
    is_playback= false;
    }


}

