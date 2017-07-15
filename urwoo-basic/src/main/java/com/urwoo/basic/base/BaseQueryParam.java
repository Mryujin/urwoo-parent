package com.urwoo.basic.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQueryParam {

    protected Date startTime;
    protected Date endTime;

}
