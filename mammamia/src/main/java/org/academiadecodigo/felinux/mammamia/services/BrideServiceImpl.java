package org.academiadecodigo.felinux.mammamia.services;

import org.academiadecodigo.felinux.mammamia.persistence.dao.BrideDao;
import org.academiadecodigo.felinux.mammamia.persistence.dao.ProposalDao;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrideServiceImpl implements BrideService{


    private BrideDao brideDao;
    private ProposalDao proposalDao;

    @Autowired
    public void setBrideDao(BrideDao brideDao) {
        this.brideDao = brideDao;
    }

    @Autowired
    public void setProposalDao(ProposalDao proposalDao) {
        this.proposalDao = proposalDao;
    }


    @Override
    public Bride get(Integer id) {
        return brideDao.findById(id);
    }

    @Transactional
    @Override
    public void saveBride(Bride bride) {
        brideDao.saveOrUpdate(bride);

    }

    @Override
    public List<Bride> listAll() {
        return brideDao.findAll();
    }

    @Override
    public void delete(Integer id) {
        brideDao.delete(id);
    }

    @Override
    public List<Proposal> listProposal(Integer id) {
        return null;
    }

    @Override
    public Proposal addProposal(Integer id, Proposal proposal) {
        return proposalDao.saveOrUpdate(proposal);
    }
}
