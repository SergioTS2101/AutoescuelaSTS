package com.stomeo.autoescuelasts;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.stomeo.autoescuelasts.databinding.ActivityScrollingBinding;

public class ScrollingActivity extends AppCompatActivity {
    private enum Temas {
        tema1, tema2, tema3, tema4;
    }

    private ActivityScrollingBinding binding;
    String temaElegido;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.collapsingToolbar;
        toolBarLayout.setTitle(getTitle());

        toolBarLayout = findViewById(R.id.collapsing_toolbar);
        tv = (TextView) findViewById(R.id.tvTexto);

        temaElegido = getIntent().getStringExtra("temaElegido");
        ScrollingActivity.Temas animal = ScrollingActivity.Temas.valueOf(temaElegido);
        switch (animal) {
            case tema1:
                tv.setText(getString(R.string.teoria_tema1));
                toolBarLayout.setTitle(getString(R.string.tema1));
                break;
            case tema2:
                tv.setText(getString(R.string.teoria_tema2));
                toolBarLayout.setTitle(getString(R.string.tema2));
                break;
            case tema3:
                tv.setText(getString(R.string.teoria_tema3));
                toolBarLayout.setTitle(getString(R.string.tema3));
                break;
            case tema4:
                tv.setText(getString(R.string.teoria_tema4));
                toolBarLayout.setTitle(getString(R.string.tema4));
                break;

        }
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, QuizActivity.class);
                intent.putExtra("temaElegido", temaElegido);
                startActivity(intent);
            }
        });
    }
}