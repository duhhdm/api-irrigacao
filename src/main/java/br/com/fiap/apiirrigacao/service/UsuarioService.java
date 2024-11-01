package br.com.fiap.apiirrigacao.service;

import br.com.fiap.apiirrigacao.entity.Usuario;
import br.com.fiap.apiirrigacao.model.UsuarioCadastroDTO;
import br.com.fiap.apiirrigacao.model.UsuarioExibicaoDTO;
import br.com.fiap.apiirrigacao.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO cadastroUsuario(UsuarioCadastroDTO usuarioDto) {
        if(usuarioExiste(usuarioDto.email()))
            return null;
        Usuario usuario = new Usuario();
        String senhaCript = new BCryptPasswordEncoder().encode(usuarioDto.senha());
        BeanUtils.copyProperties(usuarioDto,usuario);
        usuario.setSenha(senhaCript);
        return new UsuarioExibicaoDTO(usuarioRepository.save(usuario));
    }

    public boolean usuarioExiste(String email) {

        if(usuarioRepository.findByEmail(email)==null){
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = usuarioRepository.findByEmail(username);
        return userDetails;
    }

    public void deletaUsuario(String id) {
         usuarioRepository.delete(usuarioRepository.findByEmail(id));
    }
}
