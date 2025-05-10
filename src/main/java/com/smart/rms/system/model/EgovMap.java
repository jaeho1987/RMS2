package com.smart.rms.system.model;

import java.util.HashMap;

public class EgovMap extends HashMap {
    public EgovMap(){
        super();
    }

    @Override
    public Object put(Object key, Object value) {
        if(value == null) {
            value = "";
        }
        return super.put(CamelUtil.convert2CamelCase((String) key), value);
    }
}
