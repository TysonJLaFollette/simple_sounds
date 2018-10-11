package tysons_sound_synthesizer;

import javax.sound.midi.*;

public class SoundSynthesizer {
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;
    private Instrument[] instruments;
    public static void main(String[] args) throws Exception{
        SoundSynthesizer soundSynthesizer = new SoundSynthesizer();
        for(int i = 0; i < soundSynthesizer.getInstruments().length; i++){
            System.out.println(soundSynthesizer.getInstruments()[i].toString());
        }
        soundSynthesizer.getMidiChannels()[0].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[1].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[2].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[3].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[4].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[5].noteOn(60,200);
        Thread.sleep(5000);
        soundSynthesizer.getMidiChannels()[6].noteOn(60,200);
        Thread.sleep(5000);
    }

    public Instrument[] getInstruments() {
        return instruments;
    }
    public MidiChannel[] getMidiChannels(){
        return midiChannels;
    }

    public SoundSynthesizer() throws Exception {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        midiChannels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank().getInstruments();
        synthesizer.loadInstrument(instruments[0]);// Piano.
        midiChannels[0].programChange(0);
        synthesizer.loadInstrument(instruments[25]);// Steel String Guitar.
        midiChannels[1].programChange(25);
        synthesizer.loadInstrument(instruments[53]);// Choir oohs.
        midiChannels[2].programChange(53);
        synthesizer.loadInstrument(instruments[56]);// Trumpet.
        midiChannels[3].programChange(56);
        synthesizer.loadInstrument(instruments[73]);// Flute.
        midiChannels[4].programChange(73);
        synthesizer.loadInstrument(instruments[13]);// Xylophone.
        midiChannels[5].programChange(13);
        synthesizer.loadInstrument(instruments[118]);// Synth drum.
        midiChannels[6].programChange(118);
    }
    public void close(){
        synthesizer.close();
    }
    public void playSound(MidiChannel channel, int noteNumber, int velocity){
        channel.noteOn(noteNumber, velocity);
    }
    public void stopSound(MidiChannel channel, int noteNumber){
        channel.noteOff(noteNumber);
    }
}
