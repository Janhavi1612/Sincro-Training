package com.sincro.practice.Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Country implements Externalizable {
    private static final long serialVersionUID = 2L;

    private String name;
    private int code;

    public Country(){

    }
    public Country(String name, int code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name+"privateKey");
        out.writeInt(code);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String nameRead = in.readUTF();
        if(!nameRead.endsWith("privateKey")){
            throw new IOException("Corrupt data");
        }
        else{
            this.setName(nameRead.replace("privateKey",""));
            this.setCode(in.readInt());
        }

    }
}
