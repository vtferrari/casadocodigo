package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();

        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }

    public void gravar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        manager.persist(usuario);
    }

    public void update(Usuario usuario) {
        manager.persist(usuario);
    }

    public List<Usuario> listar() {
        return manager.createQuery("select u from Usuario u", Usuario.class)
                .getResultList();
    }

    public Usuario find(String email) {
        final List<Usuario> emails = manager.createQuery("select u from Usuario u where email like :email", Usuario.class)
                .setParameter("email", email.trim())
                .getResultList();
        if (emails.isEmpty()) {
            return null;
        }
        return emails.get(0);
    }

}