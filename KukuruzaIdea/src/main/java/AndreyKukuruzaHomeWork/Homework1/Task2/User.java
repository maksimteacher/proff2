package AndreyKukuruzaHomeWork.Homework1.Task2;


import java.io.Serializable;

public class User implements Serializable{
    private String login;
    private String pass;
    private int date;
    private final static String separator =";";

    public User(String login, String pass, int date) {

        this.login = login;
        this.pass = pass;
        this.date = date;
    }

    public String toFileStream() {
        return login + separator + pass + separator + date + "\n";
    }

    public static User fromFileStream(String s) {
        String[] parse = s.split(separator);
        return new User(parse[0], parse[1], Integer.parseInt(parse[2]));
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public User() {
        this("popcorn_ua", "123456789", 20);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null && (pass != null ? pass.equals(user.pass) : user.pass == null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", date=" + date +
                '}';
    }
}
