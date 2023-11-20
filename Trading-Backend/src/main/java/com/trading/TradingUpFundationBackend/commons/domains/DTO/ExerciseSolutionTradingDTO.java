package com.trading.TradingUpFundationBackend.commons.domains.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSolutionTradingDTO implements Serializable {
    private Integer id;
    private String comment;
    private String userEmail;
    private Integer exerciseId;
    private MultipartFile file;
}
