package interview.web;

import interview.domain.HiringProcessStage;
import interview.service.impl.HiringProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hiring")
public class HiringProcessController {

    @Autowired
    private HiringProcessService hiringProcessService;


    @GetMapping
    public Iterable<HiringProcessStage> getAll() {
        return hiringProcessService.findAll();
    }

    @PostMapping(value="/{id}")
    public HiringProcessStage persist(@PathVariable(value = "id") Long id){
        return hiringProcessService.persist(id);
    }
}
