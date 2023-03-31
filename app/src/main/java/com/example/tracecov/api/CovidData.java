package com.example.tracecov.api;

public class CovidData {
    private String state_name;private String district_name;
    private String recovered;
    private String confirmed;
    private String deceased;
    private String active;
    private String todayConfirmed;
    private String todayDeceased;
    private String todayRecovred;

    public CovidData(String state_name, String district_name, String recovered, String confirmed, String deceased, String active, String todayConfirmed, String todayDeceased, String todayRecovred) {
        this.state_name = state_name;
        this.district_name = district_name;
        this.recovered = recovered;
        this.confirmed = confirmed;
        this.deceased = deceased;
        this.active = active;
        this.todayConfirmed = todayConfirmed;
        this.todayDeceased = todayDeceased;
        this.todayRecovred = todayRecovred;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTodayConfirmed() {
        return todayConfirmed;
    }

    public void setTodayConfirmed(String todayConfirmed) {
        this.todayConfirmed = todayConfirmed;
    }

    public String getTodayDeceased() {
        return todayDeceased;
    }

    public void setTodayDeceased(String todayDeceased) {
        this.todayDeceased = todayDeceased;
    }

    public String getTodayRecovred() {
        return todayRecovred;
    }

    public void setTodayRecovred(String todayRecovred) {
        this.todayRecovred = todayRecovred;
    }
}
