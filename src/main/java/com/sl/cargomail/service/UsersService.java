package com.sl.cargomail.service;

import com.sl.cargomail.exception.domain.*;
import com.sl.cargomail.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UsersService {
    /**
     * Metoda pozwalająca dodać nowego użytkownika - metoda do użytku przy dodawaniu użytkowników po za frontendem
     * @param firstname
     * @param lastname
     * @param username
     * @param email
     * @param role
     * @return
     * @throws UserNotFoundException
     * @throws EmailExistException
     * @throws UsernameExistException
     * @throws MessagingException
     */
    User register(String firstname, String lastname, String username, String email, String role) throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException;

    /**
     * Metoda pobierająca wszystkich użytkowników
     * @return
     */
    List<User> getUsers();

    /**
     * Metoda wyszukująca usera po username
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * Metoda wyszukująca użytkownika po email
     * @param email
     * @return
     */
    User findUserByEmail(String email);

    /**
     * Metoda dodająca nowego użytkownika
     * @param firsName
     * @param lastName
     * @param username
     * @param email
     * @param role
     * @param isNoLocked
     * @param isActive
     * @param profileImage
     * @return
     * @throws UserNotFoundException
     * @throws EmailExistException
     * @throws UsernameExistException
     * @throws IOException
     * @throws NotAnImageFileException
     */
    User addNewUser(String firsName, String lastName, String username, String email, String role, boolean isNoLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException, NotAnImageFileException;

    /**
     * Metoda aktualizująca użytkownika
     * @param currentUsername
     * @param newFirsName
     * @param newLastName
     * @param newUsername
     * @param newEmail
     * @param role
     * @param isNoLocked
     * @param isActive
     * @param profileImage
     * @return
     * @throws UserNotFoundException
     * @throws EmailExistException
     * @throws UsernameExistException
     * @throws IOException
     * @throws NotAnImageFileException
     */
    User updateUser(String currentUsername,String newFirsName, String newLastName, String newUsername, String newEmail, String role, boolean isNoLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException, NotAnImageFileException;

    /**
     * Metoda usuwająca użytkownika
     * @param username
     * @throws IOException
     */
    void deleteUser(String username) throws IOException;

    /**
     * Metoda wysyłająca nowe hasło na maila
     * @param email
     * @throws MessagingException
     * @throws EmailNotFoundException
     */
    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    /**
     * Metoda pozwalająca zmienić zdjęcia profilowe
     * @param username
     * @param profileImage
     * @return
     * @throws UserNotFoundException
     * @throws EmailExistException
     * @throws UsernameExistException
     * @throws IOException
     * @throws NotAnImageFileException
     */
    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException, NotAnImageFileException;

    /**
     * wyszukuje użytkownika po roli - przydatne przy wyszukiwaniu kierowcy
     * @param roles
     * @return
     */
   List<User> findUsersByRole(String roles);
}
