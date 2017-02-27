/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.repository;

import claudio.happyhour.model.Cash;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author claudio
 */
public interface CashRepository extends CrudRepository<Cash, Long>{
    
}
