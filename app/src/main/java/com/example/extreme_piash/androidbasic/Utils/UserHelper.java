package com.example.extreme_piash.androidbasic.Utils;


/**
 * Created by Piash on 30-Apr-17.
 */

public class UserHelper {


/*    *//**
     * Save a {@link User} after Successful login
     * @param user
     *//*
    public static void saveUser(User user){
        Gson gson = new Gson();
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER, gson.toJson(user));
    }


    *//**
     * Get a {@link User} object
     * @return
     *//*
    public static User getUser(){
        Gson gson = new Gson();
        User user = gson.fromJson(ApplicationSingleton.getInstance().getPrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER), User.class);
        return user;
    }


    *//**
     * Returns if a {@link User} is logged in or not.
     * @return
     *//*

    public static boolean isLoggedIn(){
        if(TextUtils.isEmpty(ApplicationSingleton.getInstance().getPrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER))){
            return false;
        }else {
            return true;
        }
    }

    *//**
     * Save a logged in user's bearer token
     * @param token
     *//*
    public static void saveLoggedInUserToken(String token){
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER_TOKEN, token);
    }

    *//**
     * Get a logged in user's previously saved token
     * @return
     *//*
    public static String getLoggedInUserToken(){
        return ApplicationSingleton.getInstance().getPrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER_TOKEN);
    }


    *//**
     * This method clears all {@link UserHelper} credentials. Often called while logging out.
     *//*
    public static void dispose(){
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER, "");
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_USER_HELPER_SAVE_USER_TOKEN, "");
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_LOGGED_IN_USER_CART_KEY, "");
    }

    *//**
     * Save a cartKey for guest user
     * @param cartKey
     *//*
    public static void saveGuestUserCartKey(String cartKey){
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_GUEST_USER_CART_KEY, cartKey);
    }


    *//**
     * Return a guest user cartKey
     * @return
     *//*
    public static String getGuestUserCartKey(){
        return ApplicationSingleton.getInstance().getPrefString(IAppConstant.KEY_GUEST_USER_CART_KEY);
    }

    *//**
     * Save a cartKey for loggedin user
     * @param cartKey
     *//*
    public static void saveLoggedInUserCartKey(String cartKey){
        ApplicationSingleton.getInstance().savePrefString(IAppConstant.KEY_LOGGED_IN_USER_CART_KEY, cartKey);

    }

    *//**
     * Get a cartKey for loggedin user
     * @return
     *//*
    public static String getLoggedInUserCartKey(){
        return ApplicationSingleton.getInstance().getPrefString(IAppConstant.KEY_LOGGED_IN_USER_CART_KEY);
    }*/

}
