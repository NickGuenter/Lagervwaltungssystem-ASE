package com.lvs.Language;

import java.util.Map;

public class LanguageControl {
    private static Map<String, String> currentLanguage;
    private static LanguageControl instance = null;

    public static LanguageControl getInstance() {
        if (instance == null) {
            instance = new LanguageControl();
        }
        return instance;
    }

    public static void setLanguageGerman(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static void setLanguageEnglish(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static void setLanguageSpanish(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static void setLanguageFrench(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static void setLanguageItalian(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static String getTranslation(String key) {
        return currentLanguage.get(key);
    }
}
