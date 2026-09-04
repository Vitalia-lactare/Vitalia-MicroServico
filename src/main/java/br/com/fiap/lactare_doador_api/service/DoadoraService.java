package br.com.fiap.lactare_doador_api.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.model.Doadora;
import br.com.fiap.lactare_doador_api.repository.DoadoraRepository;

@Service
public class DoadoraService {

    @Autowired
    private DoadoraRepository repository;

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public Doadora create(Doadora doadora, String senhaPlana) {
        doadora.setSenhaHash(hash(senhaPlana));
        doadora.setDataCadastro(LocalDateTime.now());
        doadora.setDataConsentimentoLgpd(LocalDateTime.now());
        return repository.save(doadora);
    }

    public Doadora update(Long id, Doadora doadora) {
        Doadora existente = repository.findById(id).orElseThrow();
        doadora.setSenhaHash(existente.getSenhaHash());
        doadora.setDataCadastro(existente.getDataCadastro());
        doadora.setConsentimentoLgpd(existente.getConsentimentoLgpd());
        doadora.setDataConsentimentoLgpd(existente.getDataConsentimentoLgpd());
        return repository.save(doadora);
    }

    public Optional<Doadora> findById(Long id) {
        return repository.findById(id);
    }

    public List<Doadora> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private String hash(String senhaPlana) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(senhaPlana.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Algoritmo de hash indisponível", e);
        }
    }
}
