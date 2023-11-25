package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that gives responses to possible situations
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IBookTradingResponse;//Package that allows the use of the response of the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.BookTradingDeserializable;//Package that allows the use of the object BookTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package that allows to use the serializable version of the entity BookTradingEntity; BookTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.commons.domains.entity.BookTradingEntity;//Package that allows to use the Entity BookTradingEntity
import com.trading.TradingUpFundationBackend.components.NewIdEntitiesWithFiles;
import com.trading.TradingUpFundationBackend.repository.IBookTradingRepository;//Package that allows to use the repository IBookTradingRepository
import com.trading.TradingUpFundationBackend.service.IBookTradingService;//Package that allows the use of the interface "IBookTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service//Annotation who represents this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses
public class BookTradingServiceImplements implements IBookTradingService {

    private final Environment env;
    private final IBookTradingRepository repository;
    private final BookTradingDeserializable converter;
    private final NewIdEntitiesWithFiles newIdEntitiesWithFiles;

    //@Autowired//Annotation that injects the dependencies from the converter related with the entity "BookTrading"
    public BookTradingServiceImplements(BookTradingDeserializable converter, IBookTradingRepository repository, Environment env, NewIdEntitiesWithFiles newIdEntitiesWithFiles){
        this.repository = repository;
        this.converter = converter;
        this.env = env;
        this.newIdEntitiesWithFiles = newIdEntitiesWithFiles;
    }

    /**
     * Method that creates a book
     * @param bookTradingDTO The book to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createBookTrading(BookTradingDTO bookTradingDTO) {
        System.out.println(bookTradingDTO);
        try{
            int idNew;
            List<BookTradingEntity> bookTradingEntityList = this.repository.findAll();
            List<Integer> idList = new ArrayList<>();
            if(!bookTradingEntityList.isEmpty()) {
                for (BookTradingEntity bookTrading : bookTradingEntityList) {
                    idList.add (bookTrading.getId());
                }
            }
            idNew = this.newIdEntitiesWithFiles.getHigherNumber(idList) + 1;
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(idNew);
            if (bookTradingExist.isEmpty()) {
                BookTradingEntity entity = this.converter.convertBookTradingDTOToBookTradingEntity(bookTradingDTO);
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(bookTradingDTO.getFile().getOriginalFilename()));
                String imageName = StringUtils.cleanPath(Objects.requireNonNull(bookTradingDTO.getImage().getOriginalFilename()));
                String uploadDirectionFile = env.getProperty("book.file.upload.path") + File.separator + idNew;
                String uploadDirectionImage = env.getProperty("book.image.upload.path") + File.separator + idNew;
                Files.createDirectories(Paths.get(uploadDirectionFile));
                Files.createDirectories(Paths.get(uploadDirectionImage));
                Path uploadPathFile = Paths.get(uploadDirectionFile, fileName);
                Path uploadPathImage = Paths.get(uploadDirectionImage, imageName);
                Files.copy(bookTradingDTO.getFile().getInputStream(), uploadPathFile, StandardCopyOption.REPLACE_EXISTING);
                Files.copy(bookTradingDTO.getImage().getInputStream(), uploadPathImage, StandardCopyOption.REPLACE_EXISTING);
                entity.setFile(uploadPathFile.toString());
                entity.setImage(uploadPathImage.toString());
                entity.setId(idNew);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IBookTradingResponse.BOOK_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads a book
     * @param id The id of the book to be read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readABookTrading(Integer id) {
        try {
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(id);
            if(bookTradingExist.isPresent()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(bookTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }

    }

    /**
     * Method that reads all the books
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readBooksTrading(Integer level) {
        try {
            List<BookTradingEntity> booksTradingList = this.repository.findAll();
            if (!booksTradingList.isEmpty()){
                List<BookTradingEntity> listForLevel = new ArrayList<>();
                for(BookTradingEntity bookTrading : booksTradingList){
                    if(Objects.equals(bookTrading.getLevel(), level)){
                        listForLevel.add(bookTrading);
                    }
                }
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(listForLevel)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that updates a book
     * @param bookTradingDTO The book to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateBookTrading(BookTradingDTO bookTradingDTO) {
        try {
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(bookTradingDTO.getId());
            if (bookTradingExist.isPresent()) {
                BookTradingEntity entity = this.converter.convertBookTradingDTOToBookTradingEntity(bookTradingDTO);
                String existingFilePathImage = bookTradingExist.get().getImage();
                String existingFilePathFile = bookTradingExist.get().getFile();
                MultipartFile newFile = bookTradingDTO.getFile();
                MultipartFile newImage = bookTradingDTO.getImage();
                if(existingFilePathFile != null && !existingFilePathFile.isEmpty()){
                    Files.delete(Paths.get(existingFilePathFile));
                }
                if(existingFilePathImage != null && !existingFilePathImage.isEmpty()){
                    Files.delete(Paths.get(existingFilePathImage));
                }
                if(newFile != null && newImage != null && !newFile.isEmpty() && !newImage.isEmpty()){
                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(newFile.getOriginalFilename()));
                    String imageName = StringUtils.cleanPath(Objects.requireNonNull(newImage.getOriginalFilename()));
                    String uploadDirectionFile = env.getProperty("book.file.upload.path") + File.separator + bookTradingDTO.getId();
                    String uploadDirectionImage = env.getProperty("book.image.upload.path") + File.separator + bookTradingDTO.getId();
                    Files.createDirectories(Paths.get(uploadDirectionFile));
                    Files.createDirectories(Paths.get(uploadDirectionImage));
                    Path uploadPathFile = Paths.get(uploadDirectionFile, fileName);
                    Path uploadPathImage = Paths.get(uploadDirectionImage, imageName);
                    Files.copy(newFile.getInputStream(), uploadPathFile, StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(newImage.getInputStream(), uploadPathImage, StandardCopyOption.REPLACE_EXISTING);
                    entity.setFile(uploadPathFile.toString());
                    entity.setImage(uploadPathImage.toString());
                    this.repository.save(entity);
                    return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_SUCCESS)
                            .objectResponse(IBookTradingResponse.BOOK_UPDATED_SUCCESS)
                            .httpResponse(HttpStatus.OK.value())
                            .build());
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL)
                            .objectResponse(IBookTradingResponse.BOOK_UPDATE_FAILED)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .build());
                }
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL + ", BookTrading ID is missing")
                        .objectResponse(IBookTradingResponse.BOOK_UPDATE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that deletes a book
     * @param   id The book to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteBookTrading(Integer id) {
        try{
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(id);
            if(bookTradingExist.isPresent()){
                String folderPathFile = env.getProperty("book.file.upload.path") + File.separator + id;
                String folderPathImage = env.getProperty("book.image.upload.path") + File.separator + id;
                if(!folderPathFile.isEmpty()){
                    Files.walk(Paths.get(folderPathFile))
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                }
                if(!folderPathImage.isEmpty()){
                    Files.walk(Paths.get(folderPathImage))
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                }
                this.repository.deleteById(bookTradingExist.get().getId());
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IBookTradingResponse.BOOK_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ObjectResponse.builder()
                    .message(Responses.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }

    @Override
    public ResponseEntity<byte[]> getFile(Integer id){
        try {
            Optional<BookTradingEntity> bookTradingEntityExist = this.repository.findById(id);
            if(bookTradingEntityExist.isPresent()){
                BookTradingEntity entity = bookTradingEntityExist.get();
                String filePath = entity.getFile();
                var path = Paths.get(filePath);
                byte[] fileContent = Files.readAllBytes(path);
                String fileName = path.getFileName().toString();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", fileName);
                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<byte[]> getImage(Integer id){
        try {
            Optional<BookTradingEntity> bookTradingEntityExist = this.repository.findById(id);
            if(bookTradingEntityExist.isPresent()){
                BookTradingEntity entity = bookTradingEntityExist.get();
                String imagePath = entity.getImage();
                var path = Paths.get(imagePath);
                byte[] imageContent = Files.readAllBytes(path);
                String imageName = path.getFileName().toString();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", imageName);
                return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
