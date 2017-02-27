/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.repository;

import org.springframework.data.repository.CrudRepository;
import claudio.happyhour.model.Item;

/**
 *
 * @author claudio
 */

public interface ItemRepository extends CrudRepository<Item, Long> {

}
