package com.stomeo.autoescuelasts;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideosActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private int position = 0;

    private String temaElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        videoView = findViewById(R.id.video_view);

        String path;


        temaElegido = getIntent().getStringExtra("temaElegido");
        switch (temaElegido) {
            case "tema1":
                path = "android.resource://" + getPackageName() + "/" + R.raw.tema1;
                videoView.setVideoURI(Uri.parse(path));
                videoView.start();
                break;
            case "tema2":
                path = "android.resource://" + getPackageName() + "/" + R.raw.tema2;
                videoView.setVideoURI(Uri.parse(path));
                videoView.start();
                break;
            case "tema3":
                path = "android.resource://" + getPackageName() + "/" + R.raw.tema3;
                videoView.setVideoURI(Uri.parse(path));
                videoView.start();
                break;
            case "tema4":
                path = "android.resource://" + getPackageName() + "/" + R.raw.tema4;
                videoView.setVideoURI(Uri.parse(path));
                videoView.start();
                break;

        }
        if (this.mediaController == null) {
            this.mediaController = new MediaController(VideosActivity.this);

            this.mediaController.setAnchorView(videoView);
        }

        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
}