package pl.koscielecki.app.Security;

import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.GrantedAuthority;

        import java.util.Collection;

public class CurrentUser extends User {

    private final pl.koscielecki.app.model.User user;

    public CurrentUser(String email, String password, Collection<?
            extends GrantedAuthority> authorities,
                       pl.koscielecki.app.model.User user) {
        super(email,password,authorities);
        this.user = user;
    }
    public pl.koscielecki.app.model.User getUser() {
        return user;
    }
}
