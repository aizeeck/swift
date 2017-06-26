package credentials;

/**
 * Created by aizeeck on 22.05.17.
 */
public class MySQLCredential {
    private String url;
    private String uname;
    private String pass;

    public MySQLCredential(String url, String uname, String pass) {
        this.url = url;
        this.uname = uname;
        this.pass = pass;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }

    public String getUrl() {
        return url;
    }
}
