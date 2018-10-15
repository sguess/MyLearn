package com.danielpei.tw.beans;

public enum TrackType {
    MORNING(0), AFTERNOON(1), OTHERS(2);

    private int value;

    TrackType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrackType valueOf(int value) {
        TrackType[] rst = TrackType.values();
        for (TrackType trackType : rst) {
            if (trackType.getValue() == value) {
                return trackType;
            }
        }
        return OTHERS;
    }

}
