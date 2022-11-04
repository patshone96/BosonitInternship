package com.example.RestControllerFilter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Getter
@Setter
public class ControllerObject {

    private String path;
    private Map<String, String> values;
    private MultiValueMap<String, String> header;
    private String ip;

    public ControllerObject(String path, Map<String, String> values, MultiValueMap<String, String> header,
                            String ip){
        this.path = path;

        this.values = values;

        this.header = header;

        this.ip = ip;

    }

    @Override
    public String toString() {

        String result = "{\n";

        result+= "path: "+path+"\n";
        result+= "values: "+values.toString()+"\n";
        result+= "header: "+header.toString()+"\n";
        result+= "ip: "+ip+"\n"+"}";

        return result;
    }
}
