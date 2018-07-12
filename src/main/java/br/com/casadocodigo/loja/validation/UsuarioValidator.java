package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "senhaConfirmacao", "field.required");
        Usuario usuario = (Usuario) target;
        if(usuario.getSenha().length() < 6) {
            errors.rejectValue("senha", "field.more.then.five");
        }
        if(!usuario.getSenha().equalsIgnoreCase(usuario.getSenhaConfirmacao())) {
            errors.rejectValue("senhaConfirmacao", "field.not.equals");
        }

    }

}
