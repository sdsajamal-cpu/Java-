package StudentSystem;

public class user {
    private String username;
    private String personID;
    private String phonenumber;
    private String password;

    public user() {
    }

    public user(String username, String personID, String phonenumber, String password) {
        this.username = username;
        this.personID = personID;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return personID
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * 设置
     * @param personID
     */
    public void setPersonID(String personID) {
        this.personID = personID;
    }

    /**
     * 获取
     * @return phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "user{username = " + username + ", personID = " + personID + ", phonenumber = " + phonenumber + ", password = " + password + "}";
    }
}
