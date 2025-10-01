package com.example.mylib.seguranca;

import com.example.mylib.repositorios.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicoDetalhesUsuario implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicoDetalhesUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepositorio.findByEmail(username)
                .map(UserDetails.class::cast)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
