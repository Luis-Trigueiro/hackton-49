package org.academiadecodigo.felinux.mammamia.persistence.dao;

import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBrideDao extends GenericJpaDao<Bride> implements BrideDao{

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaBrideDao() {
        super(Bride.class);
    }
}
