package ink.radish.service;

import ink.radish.entity.Appinfo;
import org.springframework.data.domain.Page;

public interface AppinfoService {
    Page<Appinfo> findAll(Integer page, Integer limit);

    Page<Appinfo> findAll(Integer page, Integer limit, String search);

    void saveOne(Appinfo appinfo);

    Appinfo findOne(Integer id);

    Boolean deleteOne(Integer id);

    Boolean updateOne(Integer id, Appinfo appinfo);
}
