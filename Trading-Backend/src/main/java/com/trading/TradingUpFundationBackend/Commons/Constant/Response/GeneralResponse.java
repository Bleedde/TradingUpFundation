package com.trading.TradingUpFundationBackend.Commons.Constant.Response;

public interface GeneralResponse {
    String OPERATION_SUCCESS = "Successful operation";
    String OPERATION_FAIL = "Failed operation";
    String CREATE_SUCCESS = "Was created correctly";
    String CREATE_FAIL = "Wasn't created, was a problem";
    String UPDATE_SUCCESS = "Was successfully updated";
    String UPDATE_FAIL = "Wasn't updated, was a problem";
    String DELETE_SUCCESS = "Was successfully deleted";
    String DELETE_FAIL = "Wasn't deleted, was a problem";
    String NOT_FOUND = "Operation failed, we cant find the object";
    String INTERNAL_SERVER_ERROR = "Internal Server error";
}
