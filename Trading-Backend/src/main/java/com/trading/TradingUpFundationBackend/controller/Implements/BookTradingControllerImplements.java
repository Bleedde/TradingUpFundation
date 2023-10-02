package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IBookTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.controller.IBookTradingController;
import com.trading.TradingUpFundationBackend.service.IMPL.BookTradingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Book database manage system", description = "Create. read one, rad all, update and delete a book")
@Log4j2
@RequestMapping(IBookTradingEndPoints.URL_BOOK)
public class BookTradingControllerImplements implements IBookTradingController {

    private final BookTradingService service;

    public BookTradingControllerImplements(BookTradingService service) {
        this.service = service;
    }


    @Override
    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IBookTradingEndPoints.URL_BOOK_CREATE)
    public ResponseEntity<ObjectResponse> createBookTrading(BookTradingDTO bookTradingDTO) {
        return this.service.createBookTrading(bookTradingDTO);
    }

    @Override
    @Operation(summary = "Read a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IBookTradingEndPoints.URL_BOOK_READ)
    public ResponseEntity<ObjectResponse> readBookTrading(BookTradingDTO bookTradingDTO) {
        return this.service.readABookTrading(bookTradingDTO);
    }

    @Override
    @Operation(summary = "Read all the books")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IBookTradingEndPoints.URL_BOOKS_READ)
    public ResponseEntity<ObjectResponse> readBooksTrading() {
        return this.service.readBooksTrading();
    }

    @Override
    @Operation(summary = "Update a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IBookTradingEndPoints.URL_BOOK_UPDATE)
    public ResponseEntity<ObjectResponse> updateBookTrading(BookTradingDTO bookTradingDTO) {
        return this.service.updateBookTrading(bookTradingDTO);
    }

    @Override
    @Operation(summary = "Delete a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IBookTradingEndPoints.URL_BOOK_DELETE)
    public ResponseEntity<ObjectResponse> deleteBookTrading(BookTradingDTO bookTradingDTO) {
        return this.service.deleteBookTrading(bookTradingDTO);
    }
}
