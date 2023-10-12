package com.trading.TradingUpFundationBackend.commons.domains.DTO;

import lombok.*;

import java.io.Serializable;//Package to use this class like a byte sequence
@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
@AllArgsConstructor//Annotation who creates a constructor with all the arguments passed like parameters
@NoArgsConstructor//Annotation who creates an empty constructor
@Getter
@Setter
@ToString
public class ClassTradingDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Integer level;
    private String urlVideo;
}
