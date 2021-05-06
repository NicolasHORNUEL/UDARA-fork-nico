package fr.udara.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.model.CompteUtilisateur;
import fr.udara.model.Role;
import fr.udara.repository.CompteUtilisateurRepository;
import fr.udara.service.CompteUtilisateurService;

/**
 * @author Udara
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	/** compteUtilisateurService : CompteUtilisateurService */
	@Autowired
	private CompteUtilisateurService compteUtilisateurService;

	/** compteUtilisateurRepository : CompteUtilisateurRepository */
	@Autowired
	private CompteUtilisateurRepository compteUtilisateurRepository;
	/**
	 *
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		if (userEmail.trim().isEmpty()) {
			throw new UsernameNotFoundException("Le nom d'utilisateur est vide !");
		}

		CompteUtilisateur user = compteUtilisateurRepository.findByEmail(userEmail);

		if (user == null) {
			throw new UsernameNotFoundException("Ce compte n'existe pas!");
		}

		// TODO : username or mail ?
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMotDePasse(),
				getGrantedAuthorities(user));

	}

	/**
	 * @param compteUtilisateur
	 * @return
	 */
	private List<GrantedAuthority> getGrantedAuthorities(CompteUtilisateur compteUtilisateur) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		Role role = compteUtilisateur.getRole();

		authorities.add(new SimpleGrantedAuthority(role.getRole()));
		return authorities;

	}

}
