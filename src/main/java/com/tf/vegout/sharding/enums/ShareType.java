package com.tf.vegout.sharding.enums;

public enum ShareType {
    MOD(1,"取余分表");
    private int type;
    private String desc;
    ShareType(int type,String desc){
        this.type=type;
        this.desc= desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
