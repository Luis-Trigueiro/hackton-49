package org.academiadecodigo.felinux.mammamia.persistence.dao;

import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProposalDao extends GenericJpaDao<Proposal> implements ProposalDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaProposalDao() {
        super(Proposal.class);
    }
}
