/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;
import java.util.UUID;
/**
 *
 * @author daniel112
 */
public class TokenGenerator {
    
    public String GenerateToken() {
        return UUID.randomUUID().toString();
    }
}
