package jmaster.io.restapi.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jmaster.io.restapi.model.Role;
import jmaster.io.restapi.model.User;
import jmaster.io.restapi.repository.RoleRepository;
import jmaster.io.restapi.repository.UserRepository;
//class mới giúp chuyển các thông tin của User thành UserDetails
public class CustomUserDetails extends User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		// Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản. 
		//Đéo =))
		Set<Integer> role_ids = super.StrinToSet();
		Set<String> role_str = new HashSet<String>();
		for (int role : role_ids) {
			 role_str.add(roleRepository.findById(role).orElseThrow(()->new UsernameNotFoundException("40")).getRole());
		}
		return role_str.stream().map(role->new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());
	}
	
	public CustomUserDetails(final User user, RoleRepository roleRepository) {//Giống setter, ưu tiên constructor
		super(user.getUsername(),user.getPassword(),user.StrinToSet());
		this.roleRepository = roleRepository;
	}
	
//	Lần sau rút kinh nghiệm lm biến final của class đi, ta có thể extends nó và class=super đúng nghĩa luôn
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
//		return user.getPassword();
		return super.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
