package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;

import java.util.List;

@Repository
@Transactional
public class RoleDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Role role) {
		manager.persist(role);
	}

	public List<Role> listar() {
		return manager.createQuery("select r from Role r ", Role.class)
				.getResultList();
	}

	public Role find(String role) {
		final List<Role> roles = manager.createQuery("select r from Role r where r.nome like :role", Role.class)
				.setParameter("role", role.trim())
				.getResultList();
		if (roles.isEmpty()) {
			return null;
		}
		return roles.get(0);
	}
}
