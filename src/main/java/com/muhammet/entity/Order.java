package com.muhammet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    Integer id;
    Integer book_id;
    Integer customer_id;
    Date date;
    Integer state;
    Long create_at;
    Long update_at;

}
