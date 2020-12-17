package com.smartbi.data.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chenjiaxing
 */
public class TxtDataInput {

    private String fileUrl;

    public TxtDataInput(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public List getData() {
        return fileData(null,null);
    }

    public List<String[]> getData(String regex) {
        return fileData(regex,null);
    }

    public List<String[]> getData(String regex, int reNum) {
        return fileData(regex,reNum);
    }

    private List fileData(String regex, Integer reNum) {

        List l = new ArrayList();
        FileReader f;
        BufferedReader b;
        String s;

        try {
            f = new FileReader(fileUrl);
            b = new BufferedReader(f);
            if (regex == null) {
                while ((s = b.readLine()) != null) {
                    l.add(s);
                }
            }else {
                while ((s = b.readLine()) != null) {
                    String[] split = s.split(regex);
                    l.add(split);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reNum != null && reNum > 0) {
            for (int i = 0 ; i < reNum; i++ ){
                l.remove(0);
            }
        }
        return l;
    }

}
