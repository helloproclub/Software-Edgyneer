package com.company;

public class Pair<X, Y> {
    X kiri;
    Y kanan;

    public Pair(X kiri, Y kanan) {
        this.kiri = kiri;
        this.kanan = kanan;
    }

    public X getKiri() {
        return kiri;
    }

    public void setKiri(X kiri) {
        this.kiri = kiri;
    }

    public Y getKanan() {
        return kanan;
    }

    public void setKanan(Y kanan) {
        this.kanan = kanan;
    }

    @Override
    public String toString() {
        return "" +
                "" + kiri +
                "" + kanan +
                "";
    }
}
