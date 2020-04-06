package com.example.w1742120_cw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class EditPhraseActivity extends AppCompatActivity {
    private PhraseViewModel phraseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_phrase);

        RecyclerView recyclerView = findViewById(R.id.displayallEditRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final EditPhraseAdapter adapter = new EditPhraseAdapter(this);
        recyclerView.setAdapter(adapter);

        //noinspection deprecation
        phraseViewModel = ViewModelProviders.of(this).get(PhraseViewModel.class);
        phraseViewModel.getAllPhrases().observe(this, new Observer<List<Phrase>>() {
            @Override
            public void onChanged(List<Phrase> phrases) {
                //update recyclerview
                adapter.setPhrases(phrases);
            }
        });
    }
}