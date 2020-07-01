package ink.radish.service.impl;

import ink.radish.entity.Appinfo;
import ink.radish.mapper.AppinfoMapper;
import ink.radish.service.AppinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;

@Service
public class AppinfoServiceImpl implements AppinfoService {

    @Resource
    private AppinfoMapper appinfoMapper;

    @Override
    public Page<Appinfo> findAll(Integer page, Integer limit) {

        Pageable pageable = PageRequest.of(page, limit);

        Specification<Appinfo> specification = new Specification<Appinfo>() {
            @Override
            public Predicate toPredicate(Root<Appinfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };

        return this.appinfoMapper.findAll(specification, pageable);
    }

    @Override
    public Page<Appinfo> findAll(Integer page, Integer limit, String search) {
        Pageable pageable = PageRequest.of(page, limit);

        Specification<Appinfo> specification = new Specification<Appinfo>() {
            @Override
            public Predicate toPredicate(Root<Appinfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                return criteriaBuilder.like(name.as(String.class), "%" + search + "%");
            }
        };

        return this.appinfoMapper.findAll(specification, pageable);
    }

    @Override
    public void saveOne(Appinfo appinfo) {

        this.appinfoMapper.save(appinfo);
    }

    @Override
    public Appinfo findOne(Integer id) {

        return this.appinfoMapper.getOne(id);
    }

    @Override
    public Boolean deleteOne(Integer id) {

        Appinfo appinfo = this.findOne(id);
        if (appinfo == null) {
            return false;
        }

        this.appinfoMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateOne(Integer id, Appinfo appinfo) {

        Appinfo one = this.findOne(id);
        if (one == null) {
            return false;
        }

        this.appinfoMapper.save(appinfo);
        return true;
    }
}
