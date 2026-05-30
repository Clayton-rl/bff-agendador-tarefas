package com.javanauta.bffagendadortarefas.business;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest dto) {
        return client.salvarUsuario(dto);
    }

    public String loginUsuario(LoginRequestDTO dto) {
        return client.login(dto);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token){
       return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
       return client.atualizarDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token){
        return client.atualizarEndereco(dto, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizarTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEnderco(String token, EnderecoDTORequest dto){
        return client.cadastrarEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
      return client.cadastarTelefone(dto, token);
    }
}
