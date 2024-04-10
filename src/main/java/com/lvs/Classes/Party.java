package com.lvs.Classes;

public abstract class Party {
    private String partyName;

    public Party(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyName() {
        return this.partyName;
    }
}
