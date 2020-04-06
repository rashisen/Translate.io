package com.example.w1742120_cw02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AddPhraseAdapter extends RecyclerView.Adapter<AddPhraseAdapter.PhraseHolder> {
    private List<Phrase> phrases = new ArrayList<>();

    @NonNull
    @Override
    public PhraseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.phrase_item, parent, false);
        return new PhraseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhraseHolder holder, int position) {
        Phrase currentPhrase = phrases.get(position);
        holder.textViewPhrase.setText(currentPhrase.getDescription());
    }

    @Override
    public int getItemCount() {
        return phrases.size();
    }

    public void setPhrases(List<Phrase> phrases){
        this.phrases = phrases;
        notifyDataSetChanged();
    }

    class PhraseHolder extends RecyclerView.ViewHolder{
        private TextView textViewPhrase;

        public PhraseHolder(@NonNull View itemView) {
            super(itemView);
            textViewPhrase = itemView.findViewById(R.id.txt_view_phrase);

        }
    }
}