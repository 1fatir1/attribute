package services;

import dao.attributeRepository;
import entities.attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class attributeService {
    @Autowired
    private attributeRepository ar;

    public List<attribute> getAll()
    {
        List<attribute> list = ar.findAll();
        return list;
    }
    public Optional<attribute> getById(int id)
    {
        Optional<attribute> a = ar.findById(id);
        return a;
    }
    public attribute addAttribute(attribute att)
    {
        attribute a = ar.save(att);
        return a;
    }
    public void delAttribute(int id)
    {
         ar.deleteById(id);
    }
    public attribute updateAttribute(attribute att, int id)
    {
        att.setId(id);
        ar.save(att);
        return att;
    }
}
