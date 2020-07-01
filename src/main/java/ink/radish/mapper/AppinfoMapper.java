package ink.radish.mapper;

import ink.radish.entity.Appinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppinfoMapper extends JpaRepository<Appinfo, Integer>, JpaSpecificationExecutor<Appinfo> {
}
