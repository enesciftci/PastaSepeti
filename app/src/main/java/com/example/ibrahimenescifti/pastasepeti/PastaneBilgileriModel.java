package com.example.ibrahimenescifti.pastasepeti;

import java.util.UUID;

public class PastaneBilgileriModel {
   private UUID pastaneId;
    private String pastaneAdi;
    private String pastaneIl;
    private boolean pastaneDurum;
    private String  pastaneIlce;
    private String pastaneSemt;

    public UUID getPastaneId() {
        return pastaneId;
    }

    public void setPastaneId(UUID pastaneId) {
        this.pastaneId = pastaneId;
    }

    public String getPastaneAdi() {
        return pastaneAdi;
    }

    public void setPastaneAdi(String pastaneAdi) {
        this.pastaneAdi = pastaneAdi;
    }

    public String getPastaneIl() {
        return pastaneIl;
    }

    public void setPastaneIl(String  pastaneIl) {
        this.pastaneIl = pastaneIl;
    }

    public String getPastaneIlce() {
        return pastaneIlce;
    }

    public void setPastaneIlce(String pastaneIlce) {
        this.pastaneIlce = pastaneIlce;
    }

    public String getPastaneSemt() {
        return pastaneSemt;
    }

    public void setPastaneSemt(String pastaneSemt) {
        this.pastaneSemt = pastaneSemt;
    }

    public boolean PastaneDurum() {
        return pastaneDurum;
    }

    public void setPastaneDurum(boolean pastaneDurum) {
        this.pastaneDurum = pastaneDurum;
    }

}
