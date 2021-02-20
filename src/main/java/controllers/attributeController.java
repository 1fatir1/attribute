package controllers;

import entities.attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import services.attributeService;

import java.util.List;
import java.util.Optional;

@RestController
public class attributeController {
    @Autowired
    private attributeService as;

    @GetMapping("/attribute")
    public ResponseEntity<List<attribute>> getAttributes()
    {
        try {
            List<attribute> list = as.getAll();
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

    @GetMapping("/attribute/{id}")
    public ResponseEntity<Optional<attribute>> getAttributeById(@PathVariable("id") int id)
    {
        try {
            Optional<attribute> att = as.getById(id);
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

    @PostMapping("/attribute")
    public ResponseEntity<attribute> addCategory(@RequestBody attribute att)
    {
        attribute a=null;
        try {
            a = as.addAttribute(att);
            return ResponseEntity.of(Optional.of(a));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/attribute/{id}")
    public ResponseEntity<?> delAttribute(@PathVariable("id") int id)
    {
        try {
            as.delAttribute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/attribute/{id}")
    public ResponseEntity<attribute> updateAttribute(@RequestBody attribute att, @PathVariable("id") int id)
    {
        attribute a=null;
        try {
            a = this.as.updateAttribute(att,id);
            return ResponseEntity.of(Optional.of(a));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
