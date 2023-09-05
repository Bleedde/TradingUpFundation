package com.trading.TradingUpFundationBackend.Commons.Constant.Response;

public interface GeneralResponse {
    String OPERATION_SUCCESS = "Operación exitosa";
    String OPERATION_FAIL = "Operación fallida";
    String CREATE_SUCCESS = "OK se creo correctamente";
    String CREATE_FAIL = "No se creo correctamente";
    String UPDATE_SUCCESS = "OK se actualizo correctamente";
    String UPDATE_FAIL = "No se actualizo correctamente";
    String DELETE_SUCCESS = "OK se elimino correctamente";
    String DELETE_FAIL = "No se elimino correctamente";
    String NOT_FOUND = "Operación fallida. no requerida";
    String DOCUMENT_FAIL = "No se pudo convertir el documento: ";
    String INTERNAL_SERVER_ERROR = "Internal Server error. Error inesperado del sistema";
    String INTERNAL_SERVER = "Error interno del servidor";
}
