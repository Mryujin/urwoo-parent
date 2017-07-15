package com.urwoo.basic.base;

import com.urwoo.basic.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable{

    protected Long id;
    protected Status status;
    protected Date createTime;
    protected Date modifyTime;
}
