package com.vdweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {
    private boolean flag;
    private Object date;

    public Result() {
    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object date) {
        this.flag = flag;
        this.date = date;
    }
}
