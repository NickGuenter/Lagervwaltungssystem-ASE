package com.lvs;

import java.util.Map;

public class LanguageControl {
    private static Map<String, String> currentLanguage;

    public static void setLanguageGerman(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static void setLanguageEnglish(Map<String, String> language) {
        LanguageControl.currentLanguage = language;
    }

    public static String getTranslation(String key) {
        return currentLanguage.get(key);
    }
}
