package com.trading.TradingUpFundationBackend.commons.constant.URLs;
/**
 * interface who contains the endpoints of each controller of the entity ClassTrading
 */
public interface IClassTradingEndPoints {
    String URL_CLASS = "/class";//Go to de class area
    String URL_CLASS_CREATE = "/class_create";//Create a class area
    String URL_CLASS_DELETE = "/class_delete/{id}";//Delete a class area
    String URL_CLASS_UPDATE = "/class_update";//Update a class area
    String URL_CLASS_READ = "/class_read";//Search a class area
    String URL_CLASSES_READ = "/classes_read";//Search all the classes area
}
