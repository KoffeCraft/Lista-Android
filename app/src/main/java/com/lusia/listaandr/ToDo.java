package com.lusia.listaandr;

public class ToDo {
    private String nazwa;
    private boolean czyWykonane;
    private byte priorytet;

    public ToDo(String nazwa, byte priorytet){
        this.nazwa = nazwa;
        this.priorytet = priorytet;
        czyWykonane = false;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "nazwa='" + nazwa + '\'' +
                ", priorytet=" + priorytet +
                '}';
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean isCzyWykonane() {
        return czyWykonane;
    }

    public void setCzyWykonane(boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    public byte getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(byte priorytet) {
        this.priorytet = priorytet;
    }
}
