package com.yyq.base.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public class BaseExample<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String UNDERLINE = "_";

    private List<String> fields;

    private List<Integer> limit;

    public void setFields(List<String> fields) {
        if (fields == null) {
            return;
        }
        List<String> columns = new ArrayList<String>();
        for (String column : fields) {
            String field = toUnderlineCase(column);
            columns.add(field);
        }
        this.fields = columns;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setColunms(List<String> columns) {
        this.fields = columns;
    }

    public void setLimit(List<Integer> limit) {
        this.limit = limit;
    }

    private String toUnderlineCase(String camelCaseStr) {
        if (camelCaseStr == null) {
            return null;
        }

        final int length = camelCaseStr.length();
        StringBuilder sb = new StringBuilder();
        char c;
        boolean isPreUpperCase = false;
        for (int i = 0; i < length; i++) {
            c = camelCaseStr.charAt(i);
            boolean isNextUpperCase = true;
            if (i < (length - 1)) {
                isNextUpperCase = Character.isUpperCase(camelCaseStr.charAt(i + 1));
            }
            if (Character.isUpperCase(c)) {
                if (!isPreUpperCase || !isNextUpperCase) {
                    if (i > 0)
                        sb.append(UNDERLINE);
                }
                isPreUpperCase = true;
            } else {
                isPreUpperCase = false;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
