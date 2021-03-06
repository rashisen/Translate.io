package com.example.w1742120_cw02;

import android.util.Log;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;


class IBMCloudService {

    //get language translator service
    static LanguageTranslator getLanguageTranslatorService(String key, String url, String version) {
        IamAuthenticator authenticator = new IamAuthenticator(key);
        LanguageTranslator langTranslator = new LanguageTranslator(version, authenticator);
        langTranslator.setServiceUrl(url);
        Log.i("API", "/"+key + " " + url + " " + version);
        return langTranslator;
    }

}


