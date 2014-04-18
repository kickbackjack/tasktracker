/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.service;

import com.tasktracker.bean.UserAccount;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jack
 */
@Service("assembler")
public class UserAssembler {
    
    @Transactional(readOnly = true)
    public User buildUserFromUserEntity(UserAccount userAccount) {
        String username = userAccount.getEmail();
//        String password = userAccount.getPassword();
        boolean enabled = userAccount.getActive();
        boolean accountNonExpired = enabled;
        boolean credentialsNonExpired = enabled;
        boolean accountNonLocked = enabled;
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            for(Role role : userAccount.getRoles()) {
//                    authorities.add(new SimpleGrantedAuthority(role.getName()));
//            }

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
//        User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        User user = new User(username, "password", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return user;
    }
}
