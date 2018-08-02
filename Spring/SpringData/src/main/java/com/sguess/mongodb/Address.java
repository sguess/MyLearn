package com.sguess.mongodb;

public class Address {
    private String addrName;
    private int addrNo;

    public Address() {
    }

    public Address(String addrName, int addrNo) {
        this.addrName = addrName;
        this.addrNo = addrNo;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public int getAddrNo() {
        return addrNo;
    }

    public void setAddrNo(int addrNo) {
        this.addrNo = addrNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addrName='" + addrName + '\'' +
                ", addrNo=" + addrNo +
                '}';
    }
}
