package services;

import dao.attributeTermRepository;
import entities.attributeTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class attributeTermService {
    @Autowired
    private attributeTermRepository atr;

    public List<attributeTerm> getAll()
    {
        List<attributeTerm> list = atr.findAll();
        return list;
    }
    public Optional<attributeTerm> getById(int id)
    {
        Optional<attributeTerm> a = atr.findById(id);
        return a;
    }
    public attributeTerm addAttributeTerm(attributeTerm att)
    {
        attributeTerm a = atr.save(att);
        return a;
    }
    public void delAttributeTerm(int id)
    {
        atr.deleteById(id);
    }
    public attributeTerm updateAttributeTerm(attributeTerm att, int id)
    {
        att.setTid(id);
        atr.save(att);
        return att;
    }
}
