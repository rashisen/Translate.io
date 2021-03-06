package com.example.w1742120_cw02;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LanguageRepository {

    private LanguageDao languageDao;
    private LiveData<List<Language>> allLanguages;
    private LiveData<List<Language>> allSubscribedLanguages;

    public LanguageRepository(Application application){
        TioDatabase tioDatabase = TioDatabase.getInstance(application);
        languageDao = tioDatabase.languageDao();
        allLanguages = languageDao.getAllLanguages();
        allSubscribedLanguages = languageDao.subscribedLanguages();
    }

    //insert a language
    public void insert(Language language){
        new InsertLangAsyncTask(languageDao).execute(language);
    }

    //update a checkbox value
    public void updateCheck(Language language){
        new UpdateCheckAsyncTask(languageDao).execute(language);
    }

    //update language
    public void update(Language language){
        new UpdateLangAsyncTask(languageDao).execute(language);
    }

    //delete language
    public void delete(Language language){
        new DeleteLangAsyncTask(languageDao).execute(language);
    }

    //return all subscribed languages
    public LiveData<List<Language>> getSubscribedLanguages(){
        return allSubscribedLanguages;
    }

    //return all languages
    public LiveData<List<Language>> getAllLanguages(){
        return allLanguages;
    }

    /**
     * Async task to insert a language to the database
     */
    private static class InsertLangAsyncTask extends AsyncTask<Language,Void,Void> {
        private LanguageDao languageDao;

        private InsertLangAsyncTask(LanguageDao languageDao){
            this.languageDao = languageDao;
        }

        @Override
        protected Void doInBackground(Language... languages) {
            languageDao.insertlang(languages[0]);
            return null;
        }
    }


    /**
     * Async task to update language
     */
    private static class UpdateLangAsyncTask extends AsyncTask<Language,Void,Void> {
        private LanguageDao languageDao;

        private UpdateLangAsyncTask(LanguageDao languageDao){
            this.languageDao = languageDao;
        }

        @Override
        protected Void doInBackground(Language... languages) {
            languageDao.updatelang(languages[0]);
            return null;
        }
    }

    /**
     * Async task to delete language from database
     */
    private static class DeleteLangAsyncTask extends AsyncTask<Language,Void,Void> {
        private LanguageDao languageDao;

        private DeleteLangAsyncTask(LanguageDao languageDao){
            this.languageDao = languageDao;
        }

        @Override
        protected Void doInBackground(Language... languages) {
            languageDao.deletelang(languages[0]);
            return null;
        }
    }


    /**
     * Async task to delete all languages from the database
     */
    private static class DeleteAllLangAsyncTask extends AsyncTask<Void,Void,Void> {
        private LanguageDao languageDao;

        private DeleteAllLangAsyncTask(LanguageDao languageDao){
            this.languageDao = languageDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            languageDao.deleteAllLanguages();
            return null;
        }
    }

    /**
     * Async task to update the checkbox value
     */
    private static class UpdateCheckAsyncTask extends AsyncTask<Language, Void, Void>{

        private LanguageDao languageDao;

        private UpdateCheckAsyncTask(LanguageDao languageDao){
            this.languageDao = languageDao;
        }
        @Override
        protected Void doInBackground(Language... languages) {
            languageDao.updateState(languages[0].getLangId(), languages[0].getCheckValue());
            return null;
        }
    }


}
