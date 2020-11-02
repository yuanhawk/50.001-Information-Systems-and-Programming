package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

/**
 * Created by ngaiman_cheung on 17/10/16.
 */
public class TestPiano {
    public static void main(String[] args) {

        try {
            Midi midi;
            PianoMachine pm;
            midi = Midi.getInstance();
            midi.clearHistory();
            pm = new PianoMachine();

            System.out.println("Recording 1");
            pm.toggleRecording();
            pm.beginNote(new Pitch(3));
            pm.beginNote(new Pitch(5));
            Midi.rest(10);
            pm.endNote(new Pitch(3));
            pm.endNote(new Pitch(5));
            pm.toggleRecording();

            System.out.println(midi.history());
            midi.clearHistory();
            Midi.rest(10);
            System.out.println("Playback 1");
            pm.playback();
            Midi.rest(10);

            System.out.println(midi.history());
            midi.clearHistory();

            System.out.println("Recording 2");
            pm.toggleRecording();
            pm.beginNote(new Pitch(4));
            Midi.rest(20);
            pm.endNote(new Pitch(4));
            pm.beginNote(new Pitch(6));
            Midi.rest(40);
            pm.endNote(new Pitch(6));
            pm.toggleRecording();

            System.out.println(midi.history());
            midi.clearHistory();
            Midi.rest(10);
            System.out.println("Playback 2");
            pm.playback();
            Midi.rest(10);

            System.out.println(midi.history());
            midi.clearHistory();

            System.out.println("Playback 2 Again");
            pm.playback();
            Midi.rest(10);
            System.out.println(midi.history());
            midi.clearHistory();

            pm.changeInstrument();

            System.out.println("Recording 3");
            pm.toggleRecording();
            pm.beginNote(new Pitch(3));
            pm.beginNote(new Pitch(5));
            Midi.rest(10);
            pm.endNote(new Pitch(5));
            pm.endNote(new Pitch(3));
            pm.toggleRecording();

            System.out.println(midi.history());
            midi.clearHistory();
            Midi.rest(10);
            System.out.println("Playback 3");
            pm.playback();
            Midi.rest(10);

            System.out.println(midi.history());


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }



    }

}