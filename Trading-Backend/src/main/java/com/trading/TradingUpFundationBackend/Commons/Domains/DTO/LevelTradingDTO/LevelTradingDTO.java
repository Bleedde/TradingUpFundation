package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;//Import of the entity "Book"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;//Import of the entity "Class"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;//Import of the entity "Content"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;//Import of the entity "Excercise"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.RegistrationTradingEntity.RegistrationTradingEntity;//Import of the entity "Registration"
import lombok.AllArgsConstructor;//Import to use all the arguments that a constructor normally has
import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has
import lombok.NoArgsConstructor;//Import who allow to create an object without args in the constructor

import java.io.Serializable;//Package to use this class like a byte sequence
import java.sql.Date;//Package to use the type of data "Date"
import java.util.List;//Package to use the dynamic list "List"

@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
@AllArgsConstructor//Annotation who creates a constructor with all the arguments passed like parameters
@NoArgsConstructor//Annotation who creates an empty constructor
/**
 * Class who creates an objecto with a type DTO to the entity "LevelTrading"
 * Implements the interface Serializable
 */

public class LevelTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private Date dataStart;
    private Date dataEnd;
    private Integer amount;
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;
    private List<ContentTradingEntity> contentTradingEntityRelation;
    private List<ExcerciseTradingEntity> excerciseTradingEntityRelation;
    private List<BookTradingEntity> bookTradingEntityRelation;
    private List<ClassTradingEntity> classTradingEntityRelation;
}
