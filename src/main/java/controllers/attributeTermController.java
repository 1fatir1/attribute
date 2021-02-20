package controllers;

import entities.attributeTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import services.attributeTermService;
import java.util.List;
import java.util.Optional;

@RestController
public class attributeTermController {
    @Autowired
    private attributeTermService ats;

    @GetMapping("/attributeTerm")
    public ResponseEntity<List<attributeTerm>> getAttributeTerms()
    {
        try {
            List<attributeTerm> list = ats.getAll();
            if(list.size()<=0)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else
                return ResponseEntity.of(Optional.of(list));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/attributeTerm/{id}")
    public ResponseEntity<Optional<attributeTerm>> getAttributeById(@PathVariable("id") int id)
    {
        try {
            Optional<attributeTerm> att = ats.getById(id);
            if(att==null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else
                return ResponseEntity.of(Optional.of(att));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/attributeTerm")
    public ResponseEntity<attributeTerm> addAttributeTerm(@RequestBody attributeTerm att)
    {
        attributeTerm a=null;
        try {
            a = ats.addAttributeTerm(att);
            return ResponseEntity.of(Optional.of(a));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/attributeTerm/{id}")
    public ResponseEntity<?> delAttributeTerm(@PathVariable("id") int id)
    {
        try {
            ats.delAttributeTerm(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/attributeTerm/{id}")
    public ResponseEntity<attributeTerm> updateAttributeTerm(@RequestBody attributeTerm att, @PathVariable("id") int id)
    {
        attributeTerm a=null;
        try {
            a = this.ats.updateAttributeTerm(att,id);
            return ResponseEntity.of(Optional.of(a));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
