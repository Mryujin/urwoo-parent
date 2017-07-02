package com.urwoo.basic.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

    protected Integer id;
    protected Date createDate;
    protected Date modifyDate;
}
