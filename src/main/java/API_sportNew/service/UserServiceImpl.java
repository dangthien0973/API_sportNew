/*
 * package API_sportNew.service;
 * 
 * import java.util.ArrayList;
 * 
 * import API_sportNew.entity.Role; import API_sportNew.entity.useraccount;
 * import API_sportNew.repository.RoleRepository; import
 * API_sportNew.repository.UserRepository; import
 * lombok.RequiredArgsConstructor; import lombok.extern.slf4j.Slf4j;
 * 
 * import java.util.List;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.hibernate.mapping.Collection; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service
 * 
 * @RequiredArgsConstructor
 * 
 * @Transactional
 * 
 * @Slf4j public class UserServiceImpl implements UserService { private
 * UserRepository userRepository; private RoleRepository roleRepo;
 * 
 * public UserDetails loadUserByUserName(String userName) throws
 * UsernameNotFoundException { useraccount user =
 * userRepository.findByUsername(userName); if(user==null) { throw new
 * UsernameNotFoundException("User Name not found in database");
 * 
 * } else {
 * 
 * }
 * 
 * ArrayList<SimpleGrantedAuthority>authorities =new ArrayList<>(); return new
 * org.springframework.security.core.userdetails.User(user.getUsername(),
 * user.getPassword(),authorities);
 * 
 * }
 * 
 * @Override
 * 
 * public useraccount saveUser(useraccount user) { // TODO Auto-generated method
 * stub return userRepository.save(user); }
 * 
 * @Override public Role saveRole(Role role) { // TODO Auto-generated method
 * stub return roleRepo.save(role); }
 * 
 * @Override public void addRoleToUser(String usserName, String roleName) { //
 * TODO Auto-generated method stub useraccount userAccount =
 * userRepository.findByUsername(usserName);
 * 
 * Role role =roleRepo.findByRole(roleName); userAccount.getRoles().add(role);
 * 
 * 
 * }
 * 
 * @Override public useraccount getUser(String userName) { // TODO
 * Auto-generated method stub return userRepository.findByUsername(userName); }
 * 
 * @Override public List<useraccount> getlstUser() { // TODO Auto-generated
 * method stub return userRepository.findAll(); }
 * 
 * }
 */