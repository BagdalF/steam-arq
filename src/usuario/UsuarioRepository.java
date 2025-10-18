package usuario;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Camada de persistência responsável por armazenar e recuperar instâncias de
 * Usuario. Utiliza um Map em memória como armazenamento (protótipo).
 *
 * Relação na arquitetura: - UsuarioService utiliza o UsuarioRepository para
 * persistir e buscar usuários. - Não contém lógica de negócio, apenas operações
 * CRUD.
 */
public class UsuarioRepository {

    private final Map<Integer, Usuario> storage = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    public Usuario save(Usuario u) {
        if (u.getId() == 0) {
            try {
                java.lang.reflect.Field f = Usuario.class.getDeclaredField("id");
                f.setAccessible(true);
                
                f.setInt(u, seq.getAndIncrement());
                
            } catch (Exception e) {
                
                throw new RuntimeException(e);
            
            
            }
        }
    

    storage.put (u.getId

    (), u);
        return u;
    }

     
         

    
    

    public Optional<Usuario> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Optional<Usuario> findByEmail(String email) {
        return storage.values().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
