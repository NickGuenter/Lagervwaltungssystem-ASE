package com.lvs.Classes;

import com.lvs.Language.LanguageControl;

public class Customer extends Party{

    public Customer(String name, Address address) {
        super(name, address);
    }

    public void print() {
        System.out.println(LanguageControl.getTranslation("customer") + ": " + getName());
        System.out.println(LanguageControl.getTranslation("address") + ": " + getAddress());
    }

}
