/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.repository;

import claudio.happyhour.model.Item;
import claudio.happyhour.model.Worker;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author claudio
 */
public interface WorkerRepository extends CrudRepository<Worker, Long>{
    
}
