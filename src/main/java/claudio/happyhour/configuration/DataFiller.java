/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.configuration;

import claudio.happyhour.helper.SetIterableConverter;
import claudio.happyhour.model.Event;
import claudio.happyhour.model.Item;
import claudio.happyhour.model.Worker;
import claudio.happyhour.repository.CashRepository;
import claudio.happyhour.repository.EventRepository;
import claudio.happyhour.repository.ItemRepository;
import claudio.happyhour.repository.WorkerRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author claudio
 */
@Component
public class DataFiller implements CommandLineRunner {

    private final WorkerRepository wkRep;
    private final ItemRepository itRep;
    private final EventRepository evtRep;
    private final CashRepository cashRep;

    @Autowired
    public DataFiller(CashRepository cashRep, WorkerRepository wkRep, ItemRepository itRep, EventRepository evtRep) {
        this.wkRep = wkRep;
        this.itRep = itRep;
        this.evtRep = evtRep;
        this.cashRep = cashRep;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.wkRep.save(new Worker("claudio@email.com", "claudio"));
        this.wkRep.save(new Worker("felipe@email.com", "felipe"));
        this.itRep.save(new Item("beer", "3.5"));
        Item it2 = new Item("Vodka", "45.5");
        it2.setAmount(3);
        this.itRep.save(it2);
        this.itRep.save(new Item("pizza", "50"));

        Event evt = new Event();

        evt.setUseStoredCash(false);
        evt.setItems(SetIterableConverter.newHashSet(itRep.findAll()));
        evt.setWorkers(SetIterableConverter.newHashSet(wkRep.findAll()));
        evt.setTotalValue();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        evt.setDate(new Date(sdf.format(sdf.parse("06/03/2010"))));
        this.evtRep.save(evt);

    }

}
