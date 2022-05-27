package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
//    变量名要与数据库一致
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
