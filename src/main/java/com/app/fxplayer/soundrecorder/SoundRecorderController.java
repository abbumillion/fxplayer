package com.app.fxplayer.soundrecorder;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.player.visualization.soundcloud.WaveFormService;
import com.app.fxplayer.views.View;
import javafx.concurrent.Task;

import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;

public class SoundRecorderController extends Controller {
    private static  long RECORD_TIME = 0l;
    private SoundRecorderView soundRecorderView;


    SoundRecordingUtil recorder ;
    public SoundRecorderController(View view) {
        super(view);
        soundRecorderView = (SoundRecorderView) view;
    }

    @Override
    public void init() throws InterruptedException {
        recorder = new SoundRecordingUtil();
        soundRecorderView.showView();
        soundRecorderView.getStartButton().setOnAction(actionEvent -> {
            startRecord();
        });
        soundRecorderView.getListView().getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            if ( t1 != null)
            {
                File file = (File) t1;
//                MediaQueue.setMedia(new Media(file.toURI().toASCIIString()));
                Player.play();
                soundRecorderView.getWaveVisualization().getWaveService().startService(file, WaveFormService.WaveFormJob.AMPLITUDES_AND_WAVEFORM);
            }
        });
    }

    private void startRecord() {
        if (soundRecorderView.getTextField() != null)
        RECORD_TIME = Long.parseLong(soundRecorderView.getTextField().getText()) * 1000;
        Task task = new Task() {
            @Override
            public Object call() {
                try {
//                    messageLabel.setText("Recording...");
//                    timeLabel.setText();
                    recorder.start();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }
                return null;
            }
        };
        System.out.println("rrrr");
        new Thread(task).start();
        try {
            Thread.sleep(RECORD_TIME);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            recorder.stop();
            File file = new File("D:/recording" + Math.random() + ".wav");
            recorder.save(file);
            soundRecorderView.getListView().getItems().add(file);
            System.out.println("STOPPED");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("DONE");
    }
    }

