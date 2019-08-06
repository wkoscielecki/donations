package pl.koscielecki.app.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koscielecki.app.Repository.RoleRepository;
import pl.koscielecki.app.model.Role;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleFixtures {

    @Autowired
    RoleRepository roleRepository;

    public void crateAndInsertIntoDb(){
        List<Role> roles=createRole();
    }

    public List<Role> createRole() {
        List<Role> roles=new ArrayList<>();
        Role admin=new Role();
        admin.setName("ROLE_ADMIN");
        roleRepository.save(admin);

        Role user=new Role();
        user.setName("ROLE_USER");
        roleRepository.save(user);

        return roles;
    }

}
