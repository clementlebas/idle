package com.example.districtrestaurant;

public class District {

    private String districtName;

    // Image name (Without extension)
    private String flagName;
    private int numero;

    public District(String districtName, String flagName, int numero) {
        this.districtName= districtName;
        this.flagName= flagName;
        this.numero= numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString()  {
        return this.districtName+" (Numero: "+ this.numero+")";
    }
}