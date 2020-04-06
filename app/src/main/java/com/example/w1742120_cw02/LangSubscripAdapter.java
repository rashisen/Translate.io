package com.example.w1742120_cw02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class LangSubscripAdapter extends RecyclerView.Adapter<LangSubscripAdapter.LangSubscripHolder> {
    private List<Language> languages = new ArrayList<>();

    @NonNull
    @Override
    public LangSubscripHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lang_subscriptions_checkbox, parent, false);
        return new LangSubscripHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LangSubscripHolder holder, int position) {
        Language currentLang = languages.get(position);
        holder.langName.setText(currentLang.getLanguage());
        holder.langID.setText(currentLang.getLangId());
            if (currentLang.getCheckValue() == 1){
                holder.checkedState.setChecked(true);
            }else if (currentLang.getCheckValue() == 0){
                holder.checkedState.setChecked(false);
            }

    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    public void setLanguages(List<Language> languages){
        this.languages = languages;
        notifyDataSetChanged();
    }


    class LangSubscripHolder extends RecyclerView.ViewHolder{
        private MaterialTextView langName;
        private MaterialTextView langID;
        private MaterialCheckBox checkedState;

        public LangSubscripHolder(@NonNull View itemView) {
            super(itemView);
            langName = itemView.findViewById(R.id.langName);
            langID = itemView.findViewById(R.id.langID);
            checkedState = itemView.findViewById(R.id.langCheck);

        }
    }
}
