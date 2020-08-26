package org.academiadecodigo.felinux.mammamia.services;

import org.academiadecodigo.felinux.mammamia.persistence.dao.BrideDao;
import org.academiadecodigo.felinux.mammamia.persistence.dao.ProposalDao;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    @Transactional
    @Override
    public void delete(Integer id) {
        brideDao.delete(id);
    }

    @Override
    public List<Proposal> listProposal(Integer id) {
        Bride bride = brideDao.findById(id);
        return new ArrayList<>(bride.getProposals());
    }

    @Transactional
    @Override
    public Proposal addProposal(Integer id, Proposal proposal) {
       return null;
    }
}
