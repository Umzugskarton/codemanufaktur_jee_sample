package dao;



import model.User;

import java.util.Optional;

public interface AccessUser {

    User getUser(long key);

    /**
     * Get a user by it's userID
     *
     * @param email The user's email address
     * @return The user who belongs to the userID.
     */
    User getUserByEmail(String email);

    /**
     * Check login-data a users login-data with a given email address.
     *
     * @param email    Email address of the user who's logging in.
     * @param password Password of the user who's logging in.
     * @return null,                if the login was incorrect.
     * UserEntity object,	if the login was correct
     */
    Optional<User> loginByEmail(String email, String password);

    /**
     * Saves a new User in the database
     *
     * @param user The user who will be created.
     */
    void register(User user);

    /**
     * Changes the password of an user.
     *
     * @param user        The user whose password will be updated.
     * @param oldPassword
     * @param newPassword The new password.
     */
    boolean changePassword(User user, String oldPassword, String newPassword);

    void update(User user);

//	User updateUser(String userID, String email, String phone, String username);
}
