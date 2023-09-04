package com.trading.TradingUpFundationBackend.Domains.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class GenericResponseDTO implements Serializable {
    public String message;
    public Integer httpResponse;
    public Object objectResponse;
}
